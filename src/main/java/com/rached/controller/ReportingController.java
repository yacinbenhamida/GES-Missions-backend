package com.rached.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.rached.model.Mission;
import com.rached.model.OrdreMission;
import com.rached.services.AvoirBudgDepServices;
import com.rached.services.MissionServices;
import com.rached.services.OrdreConcernePayService;
import com.rached.services.OrdreMissService;
import com.rached.services.OrdreConcernePaysRepository.Results;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;
/*
 * DEDICATED SERVICE TO REPORTS 
 * SERVICE DEDIE POUR LA GENERATION DES RAPPORTS 
 */
@RestController
@RequestMapping("/api/reports")
public class ReportingController {
	
	// les missions faites pour un pays donnée
	// scheduled missions for a given country
	@Autowired
	@Qualifier("ordreMissionServiceImpl")
	OrdreMissService missions;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	@Qualifier("avoirBudgDepServicesImpl")
	AvoirBudgDepServices budgdep;
	@Autowired
	@Qualifier("ordreConcernePayServiceImpl")
	OrdreConcernePayService concerne;
	// get all missions of given country between 2 dates 
	@RequestMapping(value="/getMissionsBTDAC/{idpays}/{deb}/{fin}/{codeDep}",method= RequestMethod.GET )
	public List<OrdreMission>getMissionsBTDAC(@PathVariable("idpays")long idpays,
			@PathVariable("deb")Date debut,@PathVariable("fin")Date fin,@PathVariable("codeDep")String codeDep){
		return missions.getAllMissBTDAC(idpays, debut, fin,codeDep);
	}
	
	// get all missions of current dep between 2 dates 
		@RequestMapping(value="/getMissionsBTDA/{deb}/{fin}/{codeDep}",method= RequestMethod.GET )
		public List<OrdreMission>getMissionsBTDA(@PathVariable("deb")Date debut,@PathVariable("fin")Date fin,@PathVariable("codeDep")String codeDep){
			return missions.getAllMissBTDA(debut, fin,codeDep);
		}
		
		@RequestMapping(value="/getAllyears/{codeDep}",method = RequestMethod.GET)
		public List<Integer>getYears(@PathVariable("codeDep")String codeDep){
			return budgdep.getYears(codeDep);
		}
		
		@RequestMapping(value="/getPaysStats/{codeDep}/{year}",method = RequestMethod.GET)
		public List<Results>getPaysStats(@PathVariable("codeDep")String codeDep,@PathVariable("year")int year){
			return concerne.getPaysStats(codeDep,year);
		}
		
	/*
	@RequestMapping(value="/report",method= RequestMethod.GET )
	public JRPdfExporter rep() {
		//InputStream employeeReportStream = getClass().getResourceAsStream("../reports/Blank_A4.jrxml");
        File file = null;
        InputStream is = null;
         
        try {
             
            String path = "src\\main\\java\\com\\rached\\reports\\Blank_A4.jrxml";
             
            file = new File(path);
            is = new FileInputStream(file);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
         
        try
        {
             
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
            JRPdfExporter exporter = new JRPdfExporter();
            
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("employeeReport.pdf"));
             
            SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
            reportConfig.setSizePageToContent(true);
            reportConfig.setForceLineBreakPolicy(false);
             
            SimplePdfExporterConfiguration exportConfig = new SimplePdfExporterConfiguration();
            exportConfig.setMetadataAuthor("baeldung");
            exportConfig.setEncrypted(true);
            exportConfig.setAllowedPermissionsHint("PRINTING");
             
            exporter.setConfiguration(reportConfig);
            exporter.setConfiguration(exportConfig);
             
             exporter.exportReport();
         
        }
        catch (Exception e)
        {
            e.printStackTrace();
         
        }
		return null;
	}
	
	
	  @RequestMapping(value = "report2", method = RequestMethod.GET)
	  @ResponseBody
	  public void getRpt1(HttpServletResponse response) throws JRException, IOException {
          JasperReport jrxml = JasperCompileManager.compileReport(JRXmlLoader.load("src\\main\\java\\com\\rached\\reports\\Blank_A4.jrxml"));
		 //InputStream jasperStream =  new FileInputStream(new File("src\\main\\java\\com\\rached\\reports\\Blank_A4.jasper"));
		InputStream jasperStream = this.getClass().getResourceAsStream("reports/Blank_A4.jasper");
	    Map<String,Object> params = new HashMap<>();
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());

	    response.setContentType("application/x-pdf");
	    response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

	    final ServletOutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	  }*/
		
		@RequestMapping(value="/report",method = RequestMethod.GET)
		public @ResponseBody void generatePDF(HttpServletResponse response) throws JRException {
			InputStream jasperStream = this.getClass().getResourceAsStream("../reports/distripays.jrxml");
			JasperDesign design = JRXmlLoader.load(jasperStream);
			JasperReport report = JasperCompileManager.compileReport(design);
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, null);
			response.setContentType("application/x-pdf");
			response.setHeader("Content-Disposition", "inline : filename=result.pdf");
			try {
				final java.io.OutputStream outputStream = response.getOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint,outputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}	
