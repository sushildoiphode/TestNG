package DataProviderpack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.testng.annotations.DataProvider;

public class Wordfile {
	@DataProvider
	private void m1() throws FileNotFoundException {
	File path=new File("C:\\Users\\Dell\\Desktop\\.WordFile.docx");
	XWPFWordExtractor book=new XWPFWordExtractor("path");
	
}
}
