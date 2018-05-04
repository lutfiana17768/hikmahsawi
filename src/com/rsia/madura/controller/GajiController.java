package com.rsia.madura.controller;

import java.sql.Timestamp;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.allcolor.yahp.converter.CYaHPConverter;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer.CConvertException;

import com.rsia.madura.entity.getPegawai;
import com.rsia.madura.entity.t_Gaji;
import com.rsia.madura.entity.getGaji;
import com.rsia.madura.service.GajiService;
import com.rsia.madura.service.PegawaiService;

@Controller
@RequestMapping("/gaji")
public class GajiController {
	@Autowired
	private GajiService gajiService;
	@Autowired
	private PegawaiService pegawaiService;
	
	@RequestMapping("/list")
	public String GajiListView(Model model) {
		List<getGaji> result = gajiService.getGajis();
		
		char aktif = 'Y';
		
		model.addAttribute("gaji", result);
		model.addAttribute("varAktif", aktif);
		
		return "GajiListView";
	}
	
	@RequestMapping("/form-add")
	public String GajiFormAddView(Model model) {
		t_Gaji gajiModel = new t_Gaji();
		List<getPegawai> resultPegawai = pegawaiService.getPegawais();
		
		model.addAttribute("gajiModel", gajiModel);
		model.addAttribute("pegawai", resultPegawai);
		
		return "/gaji/GajiAddForm";
	}
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String GajiStore(@ModelAttribute("gajiModel") t_Gaji gajiModel) throws Exception{
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		gajiModel.setGajiAktif('Y');
		gajiModel.setGajiCreatedBy("Admin");
		gajiModel.setGajiCreatedDate(currentTime);
		
		gajiModel.setGajiTglBayar(gajiService.convertDateToSQLType(gajiModel.getGajiTglBayar()));
		
		gajiService.getTotal(gajiModel);
		
		gajiService.store(gajiModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/gaji/list";
	}
	
	@RequestMapping(value="/form-update", method=RequestMethod.GET)
	public String GajiFormUpdateView(Model model, @RequestParam("gajiId") int gajiId) {
		t_Gaji gajiModel = gajiService.getGaji(gajiId);
		List<getPegawai> resultPegawai = pegawaiService.getPegawais();
		
		model.addAttribute("gajiModel", gajiModel);
		model.addAttribute("pegawai", resultPegawai);
		
		return "/gaji/GajiUpdateForm";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String GajiUpdate(@ModelAttribute("gajiModel") t_Gaji gajiModel) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		System.out.println(gajiModel.toString());
		gajiModel.setGajiUpdatedBy("Admin");
		gajiModel.setGajiUpdatedDate(currentTime);
		gajiService.getTotal(gajiModel);
		
		gajiService.update(gajiModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/gaji/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String GajiDelete(@RequestParam("gajiId") int gajiId) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		t_Gaji gajiModel = gajiService.getGaji(gajiId);
		
		gajiModel.setGajiDeletedDate(currentTime);
		gajiModel.setGajiAktif('T');
		
		gajiService.delete(gajiModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/gaji/list";
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "report")
    public void generatePdfReport(HttpServletRequest request, @RequestParam(name="gajiId") int gajiId, 
    		HttpServletResponse response) throws IOException{
		 System.out.println("PrintPDF start");
	        String contextFolder = request.getServletContext().getRealPath("");
	        
	        getGaji gajiReport = gajiService.getReport(gajiId);
	        
	        String htmlFileName = contextFolder + "html/" + gajiReport.getGajiNo() + ".html";
	        String pdfFileName = contextFolder + "pdf/" + gajiReport.getGajiNo() + ".pdf";

	        File htmlFile = new File(htmlFileName);
	        
	        FileWriter htmlFileWriter = new FileWriter(htmlFile);
	        htmlFileWriter.write("<p align='right'>Tanggal Bayar : " + gajiReport.getGajiTglBayar() +
	        		"<table>" + 
	        		"  <tr>" + 
	        		"    <td> No </td>" + 
	        		"    <td>: "+ gajiReport.getGajiNo() + "</td>" +
	        		"  </tr>" + 
	        		"  <tr>" + 
	        		"    <td> No Pegawai </td>" + 
	        		"    <td> :"+ gajiReport.getGajiPegawaiId().getPegawaiNo() +"</td>" +
	        		"<td width='50'></td><td width='100'></td>" +
	        		"    <td> Gaji Pokok </td>" + 
	        		"    <td> :"+ gajiReport.getGajiPokok() +"</td>" +
	        		"</tr>" +
	        		"<tr>" +
	        		"    <td> Nama Pegawai </td>" + 
	        		"    <td> :"+ gajiReport.getGajiPegawaiId().getPegawaiNama() +"</td>" +
	        		"<td></td><td></td>" +
	        		"    <td> Bonus </td>" + 
	        		"    <td> :"+ gajiReport.getGajiBonus() +"</td>" +
	        		"  </tr>" + 
	        		"<tr>" +
	        		"<tr>" +
	        		"    <td> Bulan </td>" + 
	        		"    <td> :"+ gajiReport.getGajiBulan() +"</td>" +
	        		"<td></td><td></td>" +
	        		"    <td> Potongan </td>" + 
	        		"    <td> :"+ gajiReport.getGajiPotongan() +"</td>" +
	        		"  </tr>" +
	        		"<tr>" +
	        		"    <td> Tahun </td>" + 
	        		"    <td> :"+ gajiReport.getGajiTahun() +"</td>" +
	        		"<td></td><td></td>" +
	        		"    <td> Pajak </td>" + 
	        		"    <td> :"+ gajiReport.getGajiPajak() +"% </td>" +
	        		"<tr>" +
	        		"<tr>" +
	        		"    <td> Keterangan </td>" + 
	        		"    <td> :"+ gajiReport.getGajiKeterangan() +"</td>" +
	        		"<td></td><td></td>" +
	        		"    <td> Total </td>" + 
	        		"    <td> :"+ gajiReport.getGajiPendapatan() +"</td>" +
	        		"  </tr>" +
	        		"</table>");
	        htmlFileWriter.flush();
	        htmlFileWriter.close(); 

	        // File pdfFile=new File(pdfFileName);

	        // new converter
	        CYaHPConverter converter = new CYaHPConverter();
	        // save pdf in outfile
	        File fout = new File(pdfFileName);
	        FileOutputStream out = new FileOutputStream(fout);
	        // contains configuration properties
	        Map properties = new HashMap();
	        // list containing header/footer
	        List headerFooterList = new ArrayList();
	        // add header/footer
	        headerFooterList.add(new IHtmlToPdfTransformer.CHeaderFooter("<table width=\"100%\"><tbody><tr><td align=\"left\">"
	                                + "Report Gaji</td><td align=\"right\"></tr></tbody></table>", 
	                                IHtmlToPdfTransformer.CHeaderFooter.HEADER));
	        headerFooterList.add(new IHtmlToPdfTransformer.CHeaderFooter(
	                "Rumah Sakit Ibu Anak Hikmah",
	                IHtmlToPdfTransformer.CHeaderFooter.FOOTER));
	        properties.put(IHtmlToPdfTransformer.PDF_RENDERER_CLASS,
	                IHtmlToPdfTransformer.FLYINGSAUCER_PDF_RENDERER);
	        // properties.put(IHtmlToPdfTransformer.FOP_TTF_FONT_PATH, fontPath);

	        try {
				converter.convertToPdf(htmlFile.toURI().toURL(),
				        IHtmlToPdfTransformer.A4P, headerFooterList, out, properties);
			} catch (MalformedURLException | CConvertException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        out.flush();
	        out.close();

	        FileInputStream file = new FileInputStream(fout);
	        

	        response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "inline;filename=\"" + gajiReport.getGajiNo() + ".pdf");

	        FileCopyUtils.copy(file, response.getOutputStream());
	        
	}
}
