package com.abhinav;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PdfBuilder extends AbstractPdfViewer {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		List<ResultGenerator> resultset = (List<ResultGenerator>) model.get("resultset");
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		Paragraph prg = new Paragraph();
		prg.setAlignment(Element.ALIGN_CENTER);
		prg.add("CHAITANYA BHARATHI INSTITUTE OF TECHNOLOGY");
		doc.add(prg);
		Paragraph prg1 = new Paragraph();
		prg1.setAlignment(Element.ALIGN_CENTER);
		prg1.add("INVIGILATION DUTIES");
		doc.add(prg1);
		
		doc.add(new Paragraph("Date :" +dateFormat.format(date)));
		
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] {1.0f, 3.0f, 2.0f, 2.0f, 1.0f, 2.0f});
		table.setSpacingBefore(10);
		
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);
		
		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		
		// write table header 
		cell.setPhrase(new Phrase("S.NO.", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Name of the Invigilator", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Department", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Room No.", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Reporting Time", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Signature", font));
		table.addCell(cell);
		int i=0;
		// write table row data
		for (ResultGenerator rcd : resultset) {
			i++;
			table.addCell(Integer.toString(i));
			table.addCell(rcd.getName());
			table.addCell(rcd.getDept());
			table.addCell(rcd.getRoomno());
			table.addCell("");
			table.addCell("");
		}
		
		doc.add(table);
		
	}
}