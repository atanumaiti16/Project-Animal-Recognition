import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Class0Bolt extends BaseBasicBolt {
    private static final Logger LOG = LoggerFactory.getLogger(Class0Bolt.class);
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        try {
            String s = tuple.getString(0);
            String r[] = s.split("_");
            String filename = r[0];
            String features = r[1];

            double[] feature = fromString(r[1]);
            Boolean check = checkClass0(feature);
            //insertIntoMongoDB(check);
            basicOutputCollector.emit(new Values(filename,check));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("context","status"));
    }

    private static double[] fromString(String string) {
        String[] strings = string.split(";");
        double result[] = new double[strings.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Double.parseDouble(strings[i]);
        }
        return result;
    }

/*    public static void insertIntoMongoDB(Boolean check) {
        String API_KEY = "j1ttIfJ4D9Aol5Ru3bFCtLTAilPI2-v1";
        String DATABASE_NAME = "cs5543";
        String COLLECTION_NAME = "output";
        String urlString = "https://api.mlab.com/api/1/databases/" +
                DATABASE_NAME + "/collections/" + COLLECTION_NAME + "?apiKey=" + API_KEY;
        LOG.info(urlString);

        StringBuilder result = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Context", "Class0");
            jsonObject.put("Decision", check);
            jsonObject.put("Timestamp", System.currentTimeMillis());
            writer.write(jsonObject.toString());
            LOG.info(jsonObject.toString());
            writer.close();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Uploaded data to Mongo");

    }*/

    public Boolean checkClass0(double[] feature) {
        
  if (feature[2] <= -128.0)
   if (feature[40] <= 28.0)
    if (feature[34] <= -128.0)
     if (feature[84] <= -128.0)
      if (feature[123] <= -128.0)
       if (feature[95] <= -101.0)
        if (feature[99] <= -110.0)
         if (feature[125] <= -112.0)
          return true;
         else if (feature[125] > -112.0)
          return false;
        else if (feature[99] > -110.0)
         if (feature[62] <= -109.0)
          return false;
         else if (feature[62] > -109.0)
          return false;
       else if (feature[95] > -101.0)
        if (feature[37] <= -113.0)
         if (feature[97] <= -100.0)
          return true;
         else if (feature[97] > -100.0)
          return false;
        else if (feature[37] > -113.0)
         if (feature[111] <= -92.0)
          return false;
         else if (feature[111] > -92.0)
          return false;
      else if (feature[123] > -128.0)
       if (feature[29] <= -128.0)
        if (feature[7] <= -95.0)
         if (feature[11] <= -128.0)
          return true;
         else if (feature[11] > -128.0)
          return false;
        else if (feature[7] > -95.0)
         if (feature[25] <= -128.0)
          return false;
         else if (feature[25] > -128.0)
          return false;
       else if (feature[29] > -128.0)
        if (feature[81] <= -110.0)
         if (feature[111] <= -48.0)
          return true;
         else if (feature[111] > -48.0)
          return false;
        else if (feature[81] > -110.0)
         if (feature[109] <= -125.0)
          return false;
         else if (feature[109] > -125.0)
          return false;
     else if (feature[84] > -128.0)
      if (feature[126] <= -127.0)
       if (feature[4] <= -120.0)
        if (feature[73] <= -6.0)
         if (feature[26] <= -128.0)
          return false;
         else if (feature[26] > -128.0)
          return false;
        else if (feature[73] > -6.0)
         if (feature[96] <= -114.0)
          return false;
         else if (feature[96] > -114.0)
          return true;
       else if (feature[4] > -120.0)
        if (feature[16] <= 22.0)
         if (feature[38] <= -127.0)
          return false;
         else if (feature[38] > -127.0)
          return false;
        else if (feature[16] > 22.0)
         if (feature[92] <= -119.0)
          return false;
         else if (feature[92] > -119.0)
          return true;
      else if (feature[126] > -127.0)
       if (feature[98] <= -125.0)
        if (feature[76] <= -121.0)
         if (feature[106] <= -128.0)
          return false;
         else if (feature[106] > -128.0)
          return false;
        else if (feature[76] > -121.0)
         if (feature[58] <= -124.0)
          return false;
         else if (feature[58] > -124.0)
          return false;
       else if (feature[98] > -125.0)
        if (feature[9] <= -128.0)
         if (feature[12] <= -127.0)
          return false;
         else if (feature[12] > -127.0)
          return false;
        else if (feature[9] > -128.0)
         if (feature[90] <= -125.0)
          return false;
         else if (feature[90] > -125.0)
          return false;
    else if (feature[34] > -128.0)
     if (feature[110] <= -127.0)
      if (feature[124] <= -127.0)
       if (feature[72] <= 3.0)
        if (feature[71] <= -78.0)
         if (feature[61] <= -127.0)
          return false;
         else if (feature[61] > -127.0)
          return false;
        else if (feature[71] > -78.0)
         if (feature[39] <= -115.0)
          return false;
         else if (feature[39] > -115.0)
          return false;
       else if (feature[72] > 3.0)
        if (feature[48] <= -16.0)
         if (feature[108] <= -122.0)
          return true;
         else if (feature[108] > -122.0)
          return false;
        else if (feature[48] > -16.0)
         if (feature[95] <= -114.0)
          return true;
         else if (feature[95] > -114.0)
          return false;
      else if (feature[124] > -127.0)
       if (feature[112] <= 20.0)
        if (feature[74] <= -114.0)
         if (feature[102] <= -114.0)
          return false;
         else if (feature[102] > -114.0)
          return false;
        else if (feature[74] > -114.0)
         if (feature[6] <= -128.0)
          return false;
         else if (feature[6] > -128.0)
          return false;
       else if (feature[112] > 20.0)
        if (feature[123] <= -122.0)
         if (feature[120] <= -98.0)
          return true;
         else if (feature[120] > -98.0)
          return true;
        else if (feature[123] > -122.0)
         if (feature[25] <= -107.0)
          return false;
         else if (feature[25] > -107.0)
          return true;
     else if (feature[110] > -127.0)
      if (feature[28] <= -128.0)
       if (feature[5] <= -124.0)
        if (feature[72] <= 6.0)
         if (feature[31] <= -122.0)
          return true;
         else if (feature[31] > -122.0)
          return false;
        else if (feature[72] > 6.0)
         if (feature[75] <= -123.0)
          return true;
         else if (feature[75] > -123.0)
          return false;
       else if (feature[5] > -124.0)
        if (feature[18] <= -127.0)
         if (feature[92] <= -128.0)
          return false;
         else if (feature[92] > -128.0)
          return false;
        else if (feature[18] > -127.0)
         if (feature[37] <= -17.0)
          return false;
         else if (feature[37] > -17.0)
          return true;
      else if (feature[28] > -128.0)
       if (feature[90] <= -120.0)
        if (feature[26] <= -127.0)
         if (feature[49] <= -62.0)
          return false;
         else if (feature[49] > -62.0)
          return false;
        else if (feature[26] > -127.0)
         if (feature[25] <= -112.0)
          return false;
         else if (feature[25] > -112.0)
          return false;
       else if (feature[90] > -120.0)
        if (feature[39] <= -52.0)
         if (feature[88] <= -122.0)
          return false;
         else if (feature[88] > -122.0)
          return false;
        else if (feature[39] > -52.0)
         if (feature[0] <= -128.0)
          return true;
         else if (feature[0] > -128.0)
          return false;
   else if (feature[40] > 28.0)
    if (feature[28] <= -127.0)
     if (feature[54] <= -127.0)
      if (feature[89] <= -120.0)
       if (feature[27] <= -128.0)
        if (feature[24] <= -79.0)
         if (feature[101] <= -120.0)
          return true;
         else if (feature[101] > -120.0)
          return false;
        else if (feature[24] > -79.0)
         if (feature[89] <= -125.0)
          return true;
         else if (feature[89] > -125.0)
          return false;
       else if (feature[27] > -128.0)
        if (feature[7] <= -95.0)
         if (feature[99] <= -100.0)
          return true;
         else if (feature[99] > -100.0)
          return false;
        else if (feature[7] > -95.0)
         if (feature[0] <= -49.0)
          return false;
         else if (feature[0] > -49.0)
          return false;
      else if (feature[89] > -120.0)
       if (feature[41] <= -115.0)
        if (feature[87] <= -76.0)
         if (feature[5] <= -109.0)
          return true;
         else if (feature[5] > -109.0)
          return false;
        else if (feature[87] > -76.0)
         return false;
       else if (feature[41] > -115.0)
        if (feature[7] <= -113.0)
         if (feature[48] <= 2.0)
          return true;
         else if (feature[48] > 2.0)
          return false;
        else if (feature[7] > -113.0)
         if (feature[64] <= -90.0)
          return false;
         else if (feature[64] > -90.0)
          return false;
     else if (feature[54] > -127.0)
      if (feature[58] <= -123.0)
       if (feature[45] <= -120.0)
        if (feature[75] <= -113.0)
         if (feature[39] <= -126.0)
          return true;
         else if (feature[39] > -126.0)
          return true;
        else if (feature[75] > -113.0)
         return false;
       else if (feature[45] > -120.0)
        if (feature[16] <= -116.0)
         return true;
        else if (feature[16] > -116.0)
         if (feature[68] <= -24.0)
          return false;
         else if (feature[68] > -24.0)
          return true;
      else if (feature[58] > -123.0)
       if (feature[29] <= -117.0)
        if (feature[88] <= -113.0)
         if (feature[64] <= -63.0)
          return true;
         else if (feature[64] > -63.0)
          return true;
        else if (feature[88] > -113.0)
         if (feature[94] <= -117.0)
          return true;
         else if (feature[94] > -117.0)
          return false;
       else if (feature[29] > -117.0)
        if (feature[27] <= -125.0)
         if (feature[14] <= -117.0)
          return false;
         else if (feature[14] > -117.0)
          return true;
        else if (feature[27] > -125.0)
         if (feature[3] <= -128.0)
          return false;
         else if (feature[3] > -128.0)
          return true;
    else if (feature[28] > -127.0)
     if (feature[44] <= -117.0)
      if (feature[63] <= -104.0)
       if (feature[10] <= -127.0)
        if (feature[71] <= -94.0)
         if (feature[124] <= -119.0)
          return true;
         else if (feature[124] > -119.0)
          return true;
        else if (feature[71] > -94.0)
         if (feature[82] <= -128.0)
          return false;
         else if (feature[82] > -128.0)
          return false;
       else if (feature[10] > -127.0)
        if (feature[90] <= -128.0)
         if (feature[105] <= -122.0)
          return false;
         else if (feature[105] > -122.0)
          return true;
        else if (feature[90] > -128.0)
         if (feature[21] <= -127.0)
          return true;
         else if (feature[21] > -127.0)
          return false;
      else if (feature[63] > -104.0)
       if (feature[86] <= -128.0)
        if (feature[94] <= -117.0)
         if (feature[82] <= -122.0)
          return false;
         else if (feature[82] > -122.0)
          return true;
        else if (feature[94] > -117.0)
         return false;
       else if (feature[86] > -128.0)
        if (feature[65] <= -119.0)
         if (feature[82] <= -109.0)
          return false;
         else if (feature[82] > -109.0)
          return false;
        else if (feature[65] > -119.0)
         if (feature[63] <= -94.0)
          return true;
         else if (feature[63] > -94.0)
          return false;
     else if (feature[44] > -117.0)
      if (feature[71] <= -120.0)
       if (feature[54] <= -109.0)
        if (feature[76] <= -86.0)
         if (feature[16] <= -114.0)
          return false;
         else if (feature[16] > -114.0)
          return true;
        else if (feature[76] > -86.0)
         if (feature[90] <= -113.0)
          return true;
         else if (feature[90] > -113.0)
          return false;
       else if (feature[54] > -109.0)
        if (feature[107] <= -125.0)
         return false;
        else if (feature[107] > -125.0)
         if (feature[32] <= -99.0)
          return false;
         else if (feature[32] > -99.0)
          return false;
      else if (feature[71] > -120.0)
       if (feature[35] <= -128.0)
        if (feature[102] <= -124.0)
         if (feature[75] <= -112.0)
          return false;
         else if (feature[75] > -112.0)
          return false;
        else if (feature[102] > -124.0)
         if (feature[74] <= -127.0)
          return false;
         else if (feature[74] > -127.0)
          return true;
       else if (feature[35] > -128.0)
        if (feature[23] <= -113.0)
         if (feature[113] <= -120.0)
          return true;
         else if (feature[113] > -120.0)
          return false;
        else if (feature[23] > -113.0)
         if (feature[105] <= -106.0)
          return false;
         else if (feature[105] > -106.0)
          return false;
  else if (feature[2] > -128.0)
   if (feature[110] <= -128.0)
    if (feature[52] <= -128.0)
     if (feature[92] <= -128.0)
      if (feature[31] <= -127.0)
       if (feature[25] <= -110.0)
        if (feature[61] <= -126.0)
         if (feature[59] <= -107.0)
          return true;
         else if (feature[59] > -107.0)
          return false;
        else if (feature[61] > -126.0)
         if (feature[112] <= -72.0)
          return false;
         else if (feature[112] > -72.0)
          return false;
       else if (feature[25] > -110.0)
        if (feature[101] <= -124.0)
         if (feature[16] <= -95.0)
          return true;
         else if (feature[16] > -95.0)
          return false;
        else if (feature[101] > -124.0)
         if (feature[120] <= -72.0)
          return false;
         else if (feature[120] > -72.0)
          return true;
      else if (feature[31] > -127.0)
       if (feature[72] <= -6.0)
        if (feature[98] <= -121.0)
         if (feature[9] <= -128.0)
          return true;
         else if (feature[9] > -128.0)
          return false;
        else if (feature[98] > -121.0)
         if (feature[77] <= -128.0)
          return false;
         else if (feature[77] > -128.0)
          return false;
       else if (feature[72] > -6.0)
        if (feature[29] <= -121.0)
         if (feature[24] <= -123.0)
          return true;
         else if (feature[24] > -123.0)
          return true;
        else if (feature[29] > -121.0)
         if (feature[118] <= -110.0)
          return false;
         else if (feature[118] > -110.0)
          return false;
     else if (feature[92] > -128.0)
      if (feature[72] <= -3.0)
       if (feature[13] <= -128.0)
        if (feature[30] <= -127.0)
         if (feature[99] <= -119.0)
          return false;
         else if (feature[99] > -119.0)
          return false;
        else if (feature[30] > -127.0)
         if (feature[89] <= -120.0)
          return true;
         else if (feature[89] > -120.0)
          return false;
       else if (feature[13] > -128.0)
        if (feature[114] <= -127.0)
         if (feature[6] <= -70.0)
          return false;
         else if (feature[6] > -70.0)
          return false;
        else if (feature[114] > -127.0)
         if (feature[39] <= -113.0)
          return false;
         else if (feature[39] > -113.0)
          return false;
      else if (feature[72] > -3.0)
       if (feature[60] <= -113.0)
        if (feature[71] <= -123.0)
         if (feature[5] <= -119.0)
          return true;
         else if (feature[5] > -119.0)
          return false;
        else if (feature[71] > -123.0)
         if (feature[95] <= -125.0)
          return true;
         else if (feature[95] > -125.0)
          return false;
       else if (feature[60] > -113.0)
        if (feature[64] <= -55.0)
         if (feature[60] <= -70.0)
          return false;
         else if (feature[60] > -70.0)
          return true;
        else if (feature[64] > -55.0)
         if (feature[63] <= -101.0)
          return false;
         else if (feature[63] > -101.0)
          return false;
    else if (feature[52] > -128.0)
     if (feature[70] <= -128.0)
      if (feature[94] <= -127.0)
       if (feature[29] <= -128.0)
        if (feature[7] <= -118.0)
         if (feature[111] <= -116.0)
          return false;
         else if (feature[111] > -116.0)
          return false;
        else if (feature[7] > -118.0)
         if (feature[35] <= -122.0)
          return true;
         else if (feature[35] > -122.0)
          return false;
       else if (feature[29] > -128.0)
        if (feature[48] <= 15.0)
         if (feature[125] <= -128.0)
          return false;
         else if (feature[125] > -128.0)
          return false;
        else if (feature[48] > 15.0)
         if (feature[65] <= -103.0)
          return true;
         else if (feature[65] > -103.0)
          return false;
      else if (feature[94] > -127.0)
       if (feature[99] <= -121.0)
        if (feature[108] <= -127.0)
         if (feature[71] <= -118.0)
          return false;
         else if (feature[71] > -118.0)
          return false;
        else if (feature[108] > -127.0)
         if (feature[77] <= -122.0)
          return false;
         else if (feature[77] > -122.0)
          return false;
       else if (feature[99] > -121.0)
        if (feature[14] <= -118.0)
         if (feature[7] <= -127.0)
          return false;
         else if (feature[7] > -127.0)
          return false;
        else if (feature[14] > -118.0)
         if (feature[55] <= -118.0)
          return false;
         else if (feature[55] > -118.0)
          return false;
     else if (feature[70] > -128.0)
      if (feature[16] <= 22.0)
       if (feature[86] <= -126.0)
        if (feature[22] <= -126.0)
         if (feature[75] <= -128.0)
          return false;
         else if (feature[75] > -128.0)
          return false;
        else if (feature[22] > -126.0)
         if (feature[99] <= -127.0)
          return false;
         else if (feature[99] > -127.0)
          return false;
       else if (feature[86] > -126.0)
        if (feature[74] <= -127.0)
         if (feature[44] <= -128.0)
          return false;
         else if (feature[44] > -128.0)
          return false;
        else if (feature[74] > -127.0)
         if (feature[82] <= -111.0)
          return false;
         else if (feature[82] > -111.0)
          return false;
      else if (feature[16] > 22.0)
       if (feature[89] <= -126.0)
        if (feature[93] <= -104.0)
         if (feature[96] <= -93.0)
          return true;
         else if (feature[96] > -93.0)
          return false;
        else if (feature[93] > -104.0)
         if (feature[105] <= -127.0)
          return true;
         else if (feature[105] > -127.0)
          return false;
       else if (feature[89] > -126.0)
        if (feature[52] <= -108.0)
         if (feature[28] <= -103.0)
          return false;
         else if (feature[28] > -103.0)
          return false;
        else if (feature[52] > -108.0)
         if (feature[39] <= -122.0)
          return false;
         else if (feature[39] > -122.0)
          return true;
   else if (feature[110] > -128.0)
    if (feature[92] <= -128.0)
     if (feature[29] <= -128.0)
      if (feature[52] <= -128.0)
       if (feature[56] <= -59.0)
        if (feature[59] <= -127.0)
         if (feature[94] <= -126.0)
          return true;
         else if (feature[94] > -126.0)
          return false;
        else if (feature[59] > -127.0)
         if (feature[62] <= -128.0)
          return false;
         else if (feature[62] > -128.0)
          return false;
       else if (feature[56] > -59.0)
        if (feature[109] <= -126.0)
         if (feature[48] <= 5.0)
          return false;
         else if (feature[48] > 5.0)
          return false;
        else if (feature[109] > -126.0)
         if (feature[38] <= -109.0)
          return false;
         else if (feature[38] > -109.0)
          return false;
      else if (feature[52] > -128.0)
       if (feature[32] <= -125.0)
        if (feature[60] <= -127.0)
         if (feature[57] <= -127.0)
          return false;
         else if (feature[57] > -127.0)
          return false;
        else if (feature[60] > -127.0)
         if (feature[91] <= -101.0)
          return false;
         else if (feature[91] > -101.0)
          return false;
       else if (feature[32] > -125.0)
        if (feature[14] <= -128.0)
         if (feature[69] <= -121.0)
          return false;
         else if (feature[69] > -121.0)
          return false;
        else if (feature[14] > -128.0)
         if (feature[2] <= -114.0)
          return false;
         else if (feature[2] > -114.0)
          return false;
     else if (feature[29] > -128.0)
      if (feature[122] <= -128.0)
       if (feature[107] <= -125.0)
        if (feature[120] <= -115.0)
         if (feature[126] <= -116.0)
          return true;
         else if (feature[126] > -116.0)
          return false;
        else if (feature[120] > -115.0)
         if (feature[89] <= -118.0)
          return false;
         else if (feature[89] > -118.0)
          return false;
       else if (feature[107] > -125.0)
        if (feature[30] <= -63.0)
         if (feature[23] <= -104.0)
          return false;
         else if (feature[23] > -104.0)
          return false;
        else if (feature[30] > -63.0)
         if (feature[94] <= -109.0)
          return true;
         else if (feature[94] > -109.0)
          return false;
      else if (feature[122] > -128.0)
       if (feature[45] <= -128.0)
        if (feature[108] <= -124.0)
         if (feature[56] <= -73.0)
          return false;
         else if (feature[56] > -73.0)
          return false;
        else if (feature[108] > -124.0)
         if (feature[120] <= -12.0)
          return false;
         else if (feature[120] > -12.0)
          return false;
       else if (feature[45] > -128.0)
        if (feature[64] <= -120.0)
         if (feature[68] <= -126.0)
          return true;
         else if (feature[68] > -126.0)
          return false;
        else if (feature[64] > -120.0)
         if (feature[83] <= -126.0)
          return false;
         else if (feature[83] > -126.0)
          return false;
    else if (feature[92] > -128.0)
     if (feature[44] <= -109.0)
      if (feature[114] <= -128.0)
       if (feature[80] <= 14.0)
        if (feature[98] <= -128.0)
         if (feature[35] <= -128.0)
          return false;
         else if (feature[35] > -128.0)
          return false;
        else if (feature[98] > -128.0)
         if (feature[40] <= 28.0)
          return false;
         else if (feature[40] > 28.0)
          return true;
       else if (feature[80] > 14.0)
        if (feature[55] <= -123.0)
         if (feature[119] <= -89.0)
          return true;
         else if (feature[119] > -89.0)
          return false;
        else if (feature[55] > -123.0)
         if (feature[127] <= -123.0)
          return false;
         else if (feature[127] > -123.0)
          return false;
      else if (feature[114] > -128.0)
       if (feature[40] <= 6.0)
        if (feature[76] <= -107.0)
         if (feature[22] <= -128.0)
          return false;
         else if (feature[22] > -128.0)
          return false;
        else if (feature[76] > -107.0)
         if (feature[12] <= -115.0)
          return false;
         else if (feature[12] > -115.0)
          return false;
       else if (feature[40] > 6.0)
        if (feature[115] <= -120.0)
         if (feature[85] <= -101.0)
          return false;
         else if (feature[85] > -101.0)
          return false;
        else if (feature[115] > -120.0)
         if (feature[42] <= -127.0)
          return false;
         else if (feature[42] > -127.0)
          return false;
     else if (feature[44] > -109.0)
      if (feature[52] <= -113.0)
       if (feature[87] <= -17.0)
        if (feature[87] <= -96.0)
         if (feature[96] <= -116.0)
          return false;
         else if (feature[96] > -116.0)
          return false;
        else if (feature[87] > -96.0)
         if (feature[72] <= -97.0)
          return false;
         else if (feature[72] > -97.0)
          return false;
       else if (feature[87] > -17.0)
        if (feature[43] <= -12.0)
         if (feature[49] <= -16.0)
          return false;
         else if (feature[49] > -16.0)
          return false;
        else if (feature[43] > -12.0)
         if (feature[49] <= -8.0)
          return false;
         else if (feature[49] > -8.0)
          return true;
      else if (feature[52] > -113.0)
       if (feature[56] <= -109.0)
        if (feature[100] <= -128.0)
         if (feature[103] <= -125.0)
          return false;
         else if (feature[103] > -125.0)
          return false;
        else if (feature[100] > -128.0)
         if (feature[108] <= -112.0)
          return false;
         else if (feature[108] > -112.0)
          return false;
       else if (feature[56] > -109.0)
        if (feature[48] <= -9.0)
         if (feature[40] <= -12.0)
          return false;
         else if (feature[40] > -12.0)
          return false;
        else if (feature[48] > -9.0)
         if (feature[49] <= -48.0)
          return false;
         else if (feature[49] > -48.0)
          return false;
    return false;
    }
}
