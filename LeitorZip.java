import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.zip.*;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Joyce Araujo
 */
public class Teste
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String arquivo = "C:\\Users\\Joyce Araujo\\Documents\\BioAxs";
        String tipo = null;
        try
        {
            tipo = FilenameUtils.getExtension(arquivo);
            if (tipo.equals("zip")) 
                LeZip(arquivo);
            else if (tipo.isEmpty())
                LeDiretorio(arquivo);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void LeZip(String caminhoArquivo) throws IOException
    {
        ZipFile zip = new ZipFile(caminhoArquivo); //le o arquivo
        Enumeration e = zip.entries(); //e contem uma lista de objetos ZipEntry
        while (e.hasMoreElements())
        {
            ZipEntry entrada = (ZipEntry) e.nextElement();
            System.out.println(entrada.getName());
        }
        zip.close();
    }

    public static void LeDiretorio(String arquivo)
    {
        File file = new File(arquivo);
        File fList[] = file.listFiles();

        for (int i = 0; i < fList.length; i++)
            System.out.println(fList[i].getName() + " " + new Date(fList[i].lastModified()));
    }
}
