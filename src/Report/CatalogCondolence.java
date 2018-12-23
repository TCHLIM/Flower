package Report;

import ADT.ListInterface;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import domain.MadePayment;
import java.io.FileOutputStream;
import java.sql.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class CatalogCondolence {
    
    public CatalogCondolence(){
        
    }
    
    PreparedStatement pStmt;
    
    public static void main(String[] args, String month, String year, ListInterface<MadePayment> MPList) {

        Document d = new Document();
        String printMonth = "";
  
        if (month.equals("0")) {
            printMonth = "January";
        } else if (month.equals("1")) {
            printMonth = "Febrauary";
        } else if (month.equals("2")) {
            printMonth = "March";
        } else if (month.equals("3")) {
            printMonth = "April";
        } else if (month.equals("4")) {
            printMonth = "May";
        } else if (month.equals("5")) {
            printMonth = "June";
        } else if (month.equals("6")) {
            printMonth = "July";
        } else if (month.equals("7")) {
            printMonth = "August";
        } else if (month.equals("8")) {
            printMonth = "September";
        } else if (month.equals("9")) {
            printMonth = "October";
        } else if (month.equals("10")) {
            printMonth = "November";
        } else if (month.equals("11")) {
            printMonth = "December";
        }

        try {
            PdfWriter.getInstance(d, new FileOutputStream("Catalog Order Flower Sales Report of " + printMonth + " " + year + ".pdf"));

            PdfPTable pt = new PdfPTable(4);
            String dateResult = "";

            Date date = new Date();
            SimpleDateFormat newDateFormat = new SimpleDateFormat();
            try {
                newDateFormat.applyPattern("dd.MMM.yyyy");
                dateResult = newDateFormat.format(date);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }

            Paragraph p1 = new Paragraph("Fiore Flower Shop", FontFactory.getFont(FontFactory.TIMES_BOLD, 14));
            p1.setAlignment(Element.ALIGN_CENTER);
            Paragraph p2 = new Paragraph("No.19, Lorong Perusahaan Bandar Baru, 48020, Selangor", FontFactory.getFont(FontFactory.TIMES, 14));
            p2.setAlignment(Element.ALIGN_CENTER);
            Paragraph p3 = new Paragraph("Tel: 017-5543277     Fax: 04-507 3100", FontFactory.getFont(FontFactory.TIMES_BOLD, 14));
            p3.setAlignment(Element.ALIGN_CENTER);
            Paragraph p4 = new Paragraph("Date: " + dateResult, FontFactory.getFont(FontFactory.TIMES, 14));
            p4.setAlignment(Element.ALIGN_RIGHT);

            Font font2 = new Font(FontFactory.getFont(FontFactory.TIMES_BOLD, 14));

            String text = "Catalog Order Flower Sales Report of " + printMonth + " " + year;

            Paragraph p5 = new Paragraph(text, font2);
            p5.setAlignment(Element.ALIGN_CENTER);

            d.open();
            d.add(p1);
            d.add(p2);
            d.add(p3);
            d.add(p4);
            d.add(p5);
            d.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------"));
            d.add(new Paragraph("\n"));
            pt.addCell("Order ID");
            pt.addCell("Order Name");
            pt.addCell("Order Quantity");
            pt.addCell("Order Price");

            for (int i = 0; i < MPList.size(); i++) {
                if (MPList.getEntry(i).getMPtype().equalsIgnoreCase("Condolence")) {
                    pt.addCell(String.valueOf(MPList.getEntry(i).getMPid()));
                    pt.addCell(String.valueOf(MPList.getEntry(i).getMPorderName()));
                    pt.addCell(String.valueOf(MPList.getEntry(i).getMPorderQuantity()));
                    pt.addCell(String.valueOf(MPList.getEntry(i).getMPorderPrice()));
                }

            }

            d.add(pt);
            d.close();
            System.out.print("\nPDF report printed out\n");

        } catch (Exception ex) {
            System.out.print("\nError printing out PDF\n");
        }

    }
}
