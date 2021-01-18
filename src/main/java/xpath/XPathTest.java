package xpath;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

/**
 * XPath学习
 */
public class XPathTest {
  public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    //开启验证
    documentBuilderFactory.setValidating(true);
    documentBuilderFactory.setNamespaceAware(false);
    documentBuilderFactory.setIgnoringComments(true);
    documentBuilderFactory.setIgnoringElementContentWhitespace(false);
    documentBuilderFactory.setCoalescing(false);
    documentBuilderFactory.setExpandEntityReferences(true);


    // 创建DocumentBuilder
    DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
    // 设置异常处理对象
    builder.setErrorHandler(new ErrorHandler() {
      @Override
      public void warning(SAXParseException exception) throws SAXException {

      }

      @Override
      public void error(SAXParseException exception) throws SAXException {

      }

      @Override
      public void fatalError(SAXParseException exception) throws SAXException {

      }
    });

    Document doc = builder.parse("inventory.xml");

    XPathFactory factory = XPathFactory.newInstance();

    XPath xPath = factory.newXPath();

//    xPath.compile()


  }
}
