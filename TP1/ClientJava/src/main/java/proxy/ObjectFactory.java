
package proxy;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the proxy package. 
 * <p>An ObjectFactory allows you to programmatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _Account_QNAME = new QName("http://ws/", "Account");
    private static final QName _Convert_QNAME = new QName("http://ws/", "Convert");
    private static final QName _ConvertResponse_QNAME = new QName("http://ws/", "ConvertResponse");
    private static final QName _Cmp_QNAME = new QName("http://ws/", "cmp");
    private static final QName _CmpResponse_QNAME = new QName("http://ws/", "cmpResponse");
    private static final QName _Lcpm_QNAME = new QName("http://ws/", "lcpm");
    private static final QName _LcpmResponse_QNAME = new QName("http://ws/", "lcpmResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Compte }
     * 
     * @return
     *     the new instance of {@link Compte }
     */
    public Compte createCompte() {
        return new Compte();
    }

    /**
     * Create an instance of {@link Convert }
     * 
     * @return
     *     the new instance of {@link Convert }
     */
    public Convert createConvert() {
        return new Convert();
    }

    /**
     * Create an instance of {@link ConvertResponse }
     * 
     * @return
     *     the new instance of {@link ConvertResponse }
     */
    public ConvertResponse createConvertResponse() {
        return new ConvertResponse();
    }

    /**
     * Create an instance of {@link Cmp }
     * 
     * @return
     *     the new instance of {@link Cmp }
     */
    public Cmp createCmp() {
        return new Cmp();
    }

    /**
     * Create an instance of {@link CmpResponse }
     * 
     * @return
     *     the new instance of {@link CmpResponse }
     */
    public CmpResponse createCmpResponse() {
        return new CmpResponse();
    }

    /**
     * Create an instance of {@link Lcpm }
     * 
     * @return
     *     the new instance of {@link Lcpm }
     */
    public Lcpm createLcpm() {
        return new Lcpm();
    }

    /**
     * Create an instance of {@link LcpmResponse }
     * 
     * @return
     *     the new instance of {@link LcpmResponse }
     */
    public LcpmResponse createLcpmResponse() {
        return new LcpmResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Compte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Compte }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "Account")
    public JAXBElement<Compte> createAccount(Compte value) {
        return new JAXBElement<>(_Account_QNAME, Compte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Convert }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Convert }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "Convert")
    public JAXBElement<Convert> createConvert(Convert value) {
        return new JAXBElement<>(_Convert_QNAME, Convert.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConvertResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "ConvertResponse")
    public JAXBElement<ConvertResponse> createConvertResponse(ConvertResponse value) {
        return new JAXBElement<>(_ConvertResponse_QNAME, ConvertResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cmp }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Cmp }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "cmp")
    public JAXBElement<Cmp> createCmp(Cmp value) {
        return new JAXBElement<>(_Cmp_QNAME, Cmp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmpResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CmpResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "cmpResponse")
    public JAXBElement<CmpResponse> createCmpResponse(CmpResponse value) {
        return new JAXBElement<>(_CmpResponse_QNAME, CmpResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lcpm }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Lcpm }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "lcpm")
    public JAXBElement<Lcpm> createLcpm(Lcpm value) {
        return new JAXBElement<>(_Lcpm_QNAME, Lcpm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LcpmResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LcpmResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "lcpmResponse")
    public JAXBElement<LcpmResponse> createLcpmResponse(LcpmResponse value) {
        return new JAXBElement<>(_LcpmResponse_QNAME, LcpmResponse.class, null, value);
    }

}
