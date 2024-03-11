package array;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class SaveSSLCertificate {
    public static void main(String[] args) {
        try {
            String serverURL = "jdbc:sqlserver://10.254.111.95:1436;databaseName=IIDubaiDB_DEV";
            URL url = new URL(serverURL);

            InputStream inStream = url.openConnection().getInputStream();
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);

            // Save the certificate to a .cert file
            String certFileName = "sqlserver_certificate.cert";
            OutputStream output = new FileOutputStream(certFileName);
            output.write(cert.getEncoded());
            output.close();

            System.out.println("Certificate retrieved and saved to " + certFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

