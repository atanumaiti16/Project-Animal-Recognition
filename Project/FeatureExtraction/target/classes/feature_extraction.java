/**
 * Created by atanu on 12/10/16.
 */
import org.openimaj.feature.local.list.LocalFeatureList;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.feature.local.engine.DoGSIFTEngine;
import org.openimaj.image.feature.local.keypoints.Keypoint;

import java.io.*;


public class feature_extraction {


    public static void main(String args[]) throws IOException {

        String inputFolder = "data/";
        String outputFolder = "output/";


        File dir = new File(inputFolder);
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".jpg");
            }
        });
        FileWriter fw = new FileWriter((outputFolder + "Deer_test.txt"), true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
            MBFImage mbfImage = ImageUtilities.readMBF(new File(String.valueOf(files[i])));
            DoGSIFTEngine doGSIFTEngine = new DoGSIFTEngine();
            LocalFeatureList<Keypoint> features = doGSIFTEngine.findFeatures(mbfImage.flatten());


            for (int j = 0; j < features.size(); j++) {
                double c[] = features.get(j).getFeatureVector().asDoubleVector();
                bw.write(2 + ",");
                for (int k = 0; k < c.length; k++) {
                    bw.write(c[k] + " ");
                }
                bw.newLine();
            }


        }
        bw.close();
    }
}
