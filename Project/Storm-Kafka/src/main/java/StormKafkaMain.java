import org.apache.log4j.BasicConfigurator;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.kafka.KafkaSpout;
import org.apache.storm.kafka.SpoutConfig;
import org.apache.storm.kafka.StringScheme;
import org.apache.storm.kafka.ZkHosts;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.kafka.BrokerHosts;

import java.util.Arrays;

public class StormKafkaMain {
    private static final String KAFKA_TOPIC ="video";
    public static void main(String[] args) {
        BasicConfigurator.configure();

        if (args != null && args.length > 0)
        {
            try {



                StormSubmitter.submitTopology(
                        args[0],
                        createConfig(false),
                        createTopology());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else
        {
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology(
                        "Storm_Kafka_Sample",
                    createConfig(true),
                    createTopology());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            cluster.shutdown();
        }
    }

    private static StormTopology createTopology()
    {
     /*   SpoutConfig kafkaConf = new SpoutConfig(
                new ZkHosts("localhost:2181"),
                KAFKA_TOPIC,
                "/kafka",
                "KafkaSpout");*/
        SpoutConfig kafkaConf = new SpoutConfig(
                new ZkHosts("localhost:2181"),
                KAFKA_TOPIC,
                "",
                "KafkaSpout");
        kafkaConf.scheme = new SchemeAsMultiScheme(new StringScheme());
        KafkaSpout kafkaSpout = new KafkaSpout(kafkaConf);
        TopologyBuilder topology = new TopologyBuilder();

        topology.setSpout("kafka_spout_audioFeatures", new KafkaSpout(kafkaConf), 4);
        topology.setBolt("Class0", new Class0Bolt(), 4).shuffleGrouping("kafka_spout_audioFeatures");
        topology.setBolt("Class1", new Class1Bolt(), 4).shuffleGrouping("kafka_spout_audioFeatures");
        topology.setBolt("Class2", new Class2Bolt(), 4).shuffleGrouping("kafka_spout_audioFeatures");
  
        return topology.createTopology();
    }


    private static Config createConfig(boolean local)
    {
        int workers = 1;
        Config config = new Config();
        config.setDebug(true);
        config.setMaxTaskParallelism(5);
        config.put(Config.NIMBUS_THRIFT_PORT, 6627);
        config.put(Config.STORM_ZOOKEEPER_PORT, 2181);
        config.put(Config.STORM_ZOOKEEPER_SERVERS, Arrays.asList("localhost:2181"));

        if (local)
            config.setMaxTaskParallelism(workers);
        else
            config.setNumWorkers(workers);
        return config;
    }
}
