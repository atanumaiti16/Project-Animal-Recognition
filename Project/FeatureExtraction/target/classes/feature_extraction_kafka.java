/**
 * Created by atanu on 12/10/16.
 */
import org.openimaj.feature.local.list.LocalFeatureList;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.feature.local.engine.DoGSIFTEngine;
import org.openimaj.image.feature.local.keypoints.Keypoint;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.io.*;
import java.util.Properties;

public class feature_extraction_kafka {

    private static Producer<String, String> producer;
    private final Properties properties = new Properties();

    public feature_extraction_kafka() {
        properties.put("metadata.broker.list", "localhost:9092");
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("request.required.acks", "1");
        properties.put("message.max.bytes", "10000000");
        producer = new Producer<String, String>(new ProducerConfig(properties));
    }

    public static void main(String args[]) throws IOException {
        new feature_extraction_kafka();
        String inputFolder = "data/";
        String outputFolder = "output/";

        String topic = "video";
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
                    String data1 = String.valueOf(c[k]);
                    bw.write(c[k] + " ");

                    KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, data1);
                    producer.send(data);
                    System.out.println(data);
                }
                bw.newLine();
            }


        }
        bw.close();
    }
}
