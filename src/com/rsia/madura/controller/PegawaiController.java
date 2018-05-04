package com.rsia.madura.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.rsia.madura.entity.getPegawai;
import com.rsia.madura.entity.m_Jabatan;
import com.rsia.madura.entity.m_Kelurahan;
import com.rsia.madura.entity.m_Kota;
import com.rsia.madura.entity.m_Pegawai;
import com.rsia.madura.service.JabatanService;
import com.rsia.madura.service.KelurahanService;
import com.rsia.madura.service.KotaService;
import com.rsia.madura.service.PegawaiService;
import com.rsia.madura.entity.m_Pendidikan;
import com.rsia.madura.entity.s_User;
import com.rsia.madura.service.PendidikanService;
import com.rsia.madura.service.UserService;


@Controller
@RequestMapping("/pegawai")
public class PegawaiController {
	@Autowired
	private KotaService kotaService;
	@Autowired
	private PendidikanService pendidikanService;
	@Autowired
	private PegawaiService pegawaiService;
	@Autowired
	private JabatanService jabatanService;
	@Autowired
	private KelurahanService kelurahanService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String PegawaiListView(Model model) throws Exception{
		List<getPegawai> resultPegawai = pegawaiService.getPegawais();
		model.addAttribute("pegawai", resultPegawai);
		
		return "/pegawai/PegawaiListView";
	}
	
	@RequestMapping("/form-add")
	public String PegawaiAddFormView(Model model){
		List<m_Kota> resultKota = kotaService.getKotas();
		List<m_Pendidikan> resultPendidikan = pendidikanService.getPendidikan();
		List<m_Jabatan> resultJabatan = jabatanService.getJabatans();
		List<m_Kelurahan> resultKelurahan = kelurahanService.getKelurahans();
		
		m_Pegawai pegawaiModel = new m_Pegawai();
		
		model.addAttribute("kota", resultKota);
		model.addAttribute("kelurahan", resultKelurahan);
		model.addAttribute("pendidikan", resultPendidikan);
		model.addAttribute("jabatan", resultJabatan);
		model.addAttribute("pegawaiModel", pegawaiModel);
		
		return "/pegawai/PegawaiAddForm";
	}
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	public String pegawaiStore(@ModelAttribute("pegawaiModel") m_Pegawai pegawaiModel, 
			HttpServletRequest request, @RequestParam("file") CommonsMultipartFile pegawaiFoto) throws Exception{
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		pegawaiModel.setPegawaiAktif('Y');
		pegawaiModel.setPegawaiCreatedBy("Admin");
		pegawaiModel.setPegawaiCreatedDate(currentTime);
		pegawaiModel.setPegawaiFoto(pegawaiService.upload(request, pegawaiFoto));
		pegawaiModel.setPegawaiTglKeluar(pegawaiService.convertDateToSQLType(pegawaiModel.getPegawaiTglKeluar()));
		pegawaiModel.setPegawaiTglMasuk(pegawaiService.convertDateToSQLType(pegawaiModel.getPegawaiTglMasuk()));
		pegawaiModel.setPegawaiTglLahir(pegawaiService.convertDateToSQLType(pegawaiModel.getPegawaiTglLahir()));
		
		s_User userModel = new s_User();
		
		pegawaiService.store(pegawaiModel);
		
		userModel.setPegawaiId(pegawaiService.getId());
		System.out.println(userModel.getPegawaiId());
		userModel.setUserName(Integer.toString(userModel.getPegawaiId()));
		userModel.setUserAktif('Y');
		userModel.setUserCreatedBy("Admin");
		userModel.setUserCreatedDate(currentTime);
		userModel.setUserUpdatedBy("Admin");
		userModel.setUserUpdatedDate(currentTime);
		userModel.setUserPassword(pegawaiModel.getPegawaiTglLahir().toString());
		
		userService.store(userModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/pegawai/list";
	}
	
	@RequestMapping(value="/form-update", method=RequestMethod.GET)
	public String pegawaiFormUpdateView(Model model, @RequestParam("pegawaiId") int pegawaiId) {
		m_Pegawai result = pegawaiService.getPegawai(pegawaiId);
		List<m_Kota> resultKota = kotaService.getKotas();
		List<m_Pendidikan> resultPendidikan = pendidikanService.getPendidikan();
		List<m_Jabatan> resultJabatan = jabatanService.getJabatans();
		
		
		model.addAttribute("kota", resultKota);
		model.addAttribute("pendidikan", resultPendidikan);
		model.addAttribute("jabatan", resultJabatan);
		model.addAttribute("pegawaiModel", result);
		
		return "/pegawai/PegawaiUpdateFormView";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String pegawaiUpdate(@ModelAttribute("pegawaiModel") m_Pegawai pegawaiModel,
			HttpServletRequest request, @RequestParam("file") CommonsMultipartFile pegawaiFoto) throws Exception{
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		pegawaiModel.setPegawaiUpdatedBy("Admin");
		pegawaiModel.setPegawaiUpdatedDate(currentTime);
		pegawaiModel.setPegawaiFoto(pegawaiService.upload(request, pegawaiFoto));
		
		pegawaiService.update(pegawaiModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/pegawai/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String pegawaiDelete(@RequestParam("pegawaiId") int pegawaiId) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		m_Pegawai pegawaiModel = pegawaiService.getPegawai(pegawaiId);
		pegawaiModel.setPegawaiAktif('T');
		pegawaiModel.setPegawaiDeletedDate(currentTime);
		
		pegawaiService.delete(pegawaiModel);
		
		return "redirect:http://localhost:8080/com.rsia.modura/pegawai/list";
		
	}
}
