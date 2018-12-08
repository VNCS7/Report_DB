package report;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.List;

import model.Aluno;

public class AlunoRelatorio {
	private String path;
	
	private String pathToReportPackage; 

	public AlunoRelatorio() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "report/";
		System.out.println(path);
		System.out.println(pathToReportPackage);
	}
	
	public void imprimir(List<Aluno> sql) throws Exception {
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "school.jrxml");
		
		System.out.println(report);

		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(sql));
		
		JasperExportManager.exportReportToPdfFile(print, "C:/relatorios/Relatorio.pdf");
	}

	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}

}
