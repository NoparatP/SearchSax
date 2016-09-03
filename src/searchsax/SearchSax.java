package searchsax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SearchSax {

    public static void main(String argv[]) {
        String search = "man";
        System.out.println("Search about : " + search);

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {

                boolean btitle = false;
                boolean byear = false;
                boolean btype1 = false;
                boolean btype2 = false;
                boolean btype3 = false;
                boolean bdirector = false;
                boolean btime = false;

                public void startElement(String uri, String localName, String qName,
                        Attributes attributes) throws SAXException {
                     //System.out.println("Start Element :" + qName);
                    if (qName.equalsIgnoreCase("title")) {  
                        btitle = true;                                 
                    }
//                    if (qName.equalsIgnoreCase("year")) {
//                        byear = true;
//                    }
//
//                    if (qName.equalsIgnoreCase("type1")) {
//                        btype1 = true;
//                    }
//                    if (qName.equalsIgnoreCase("type2")) {
//                        btype2 = true;
//                    }
//                    if (qName.equalsIgnoreCase("type3")) {
//                        btype3 = true;
//                    }
//
//                    if (qName.equalsIgnoreCase("time")) {
//                        btime = true;
//                    }
//
//                    if (qName.equalsIgnoreCase("director")) {
//                        bdirector = true;
//                    }

                }

                public void endElement(String uri, String localName,
                        String qName) throws SAXException {
                    // System.out.println("End Element :" + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (btitle) { 
                        String SName = new String(ch, start, length);
                        if (SName.toLowerCase().contains(search.toLowerCase())){
                        System.out.println("Title : " + SName);                                                
                        }
                        btitle = false;
                    }
//
//                    if (byear) {
//                        System.out.println("Year : " + new String(ch, start, length));
//                        byear = false;
//                    }
//
//                    if (btype1) {
//                        System.out.println("Type : " + new String(ch, start, length));
//                        btype1 = false;                       
//                    }
//                    if (btype2) {
//                            System.out.println("       " +new String(ch, start, length));
//                            btype2 = false;
//                        }
//                    if (btype3) {
//                            System.out.println("       " +new String(ch, start, length));
//                            btype3 = false;
//                        }
//                    if (btime) {
//                        System.out.println("Time : " + new String(ch, start, length));
//                        btime = false;
//                    }
//
//                    if (bdirector) {
//                        System.out.println("Director : " + new String(ch, start, length));
//                        bdirector = false;
//                        System.out.println("");
//                    }

                }

            };
            saxParser.parse("input.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
