package industry.skills.logs.example.lookup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.io.IOException;
import java.util.Properties;

public class Setup {

    private static Logger logger = LogManager.getLogger(Setup.class);

    public static void addUser(String userName, String userLastName, DirContext connection) throws NamingException {
        BasicAttributes basicAttributes = new BasicAttributes();
        basicAttributes.put(new BasicAttribute("objectClass", "inetOrgPerson"));
        basicAttributes.put("sn", userLastName);

        connection.createSubcontext("cn=" + userName + ",ou=users,ou=system", basicAttributes);
    }

    public static void addClassSerialization(DirContext connection) throws NamingException, IOException {

        Foo f = new Foo();
        connection.bind("cn=f,dc=example,dc=com", f);
        Goo g = new Goo();
        connection.bind("cn=goo,dc=example,dc=com", g);
        Moo m = new Moo();
        connection.bind("cn=moo,dc=example,dc=com", m);

/*
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream).writeObject(f);
        String hex = Hex.encodeHexString(byteArrayOutputStream.toByteArray());
        BasicAttributes basicAttributes = new BasicAttributes();
        basicAttributes.put("objectClass", "domain");
        basicAttributes.put("objectClass", "javaObject");
        basicAttributes.put("objectClass", "javaSerializedObject");
        basicAttributes.put("objectClass", "top");
        basicAttributes.put("javaClassName", "industry.skills.logs.example.lookup.Foo");
        basicAttributes.put("javaSerializedData", hex);
        //basicAttributes.put("dc", "attempt");
        connection.createSubcontext("dc=attempt,dc=example,dc=com", basicAttributes);
*/
    }

    public static void main(String[] args) throws NamingException, IOException {

        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        props.put(Context.PROVIDER_URL, "ldap://localhost:10389");
        props.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
        props.put(Context.SECURITY_CREDENTIALS, "secret");
        DirContext ctx = new InitialDirContext(props);
        addClassSerialization(ctx);


/*
        //addUser("Tikva", "Amzaleg", ctx);
        String filter = "(objectClass=inetOrgPerson)";
        String[] attr = {"cn", "sn"};
        SearchControls searchControls = new SearchControls();
        searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchControls.setReturningAttributes(attr);

        NamingEnumeration<SearchResult> users = ctx.search("ou=users,ou=system", filter, searchControls);
        while (users.hasMore()) {
            SearchResult next = users.next();
            Attributes attributes = next.getAttributes();
            Arrays.stream(attr).forEach(attrName -> System.out.println(attributes.get(attrName)));
        }
*/

        //logger.info("Hello. You are running on ${jndi:ldap://localhost:10389/cn=f,dc=example,dc=com}");
    }
}
