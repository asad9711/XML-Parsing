import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class Readd extends DefaultHandler
{
	public static void main(String s[])throws Exception
	{
		SAXParser obj=SAXParserFactory.newInstance().newSAXParser();
		obj.parse(new FileInputStream("Tags.xml"),new Readd());


	}
	public void startDocument()
	{
		System.out.println("inside startDocument");
	}
	public void endDocument()
	{
		System.out.println("inside endDocument");
	}
	public void characters(char ch[],int start,int len)
	{
        System.out.println(new String(ch,start,len));
	}
	public void startElement(String uri,String localName,String qName,Attributes attr)
	{
      System.out.println("startElement   "+"<"+qName+">");
      // if(localName.equals("row"))
      // {
      // System.out.println("attribute "+attr.getQName(0)+"value "+attr.getValue("Id"));
      // System.out.println("attribute "+attr.getQName(1)+"value "+attr.getValue("TagName"));
      // System.out.println("attribute "+attr.getQName(2)+"value "+attr.getValue("Count"));
      // }

      for(int i=0;i<attr.getLength();i++)
      {
      	System.out.println("attribute "+attr.getQName(i)+" value "+attr.getValue(i));
      }
	} 
	public void endElement(String uri,String localName,String qName)
	{
System.out.println("endElement  "+"</ "+qName);
	}





}