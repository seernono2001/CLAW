import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class YTCleanReducer extends Reducer<Text, Text, Text, Text> {

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {

    java.util.Set<String> seenDates = new java.util.HashSet<>();

    for (Text val : values) {
      String row = val.toString();

      String[] fields = row.split("\t", -1);
      if (fields.length < 2) continue;

      String trendingDate = fields[1];

      if (seenDates.contains(trendingDate)) {
        context.getCounter("Cleaning", "dropped_exact_duplicates").increment(1);
      } else {
        seenDates.add(trendingDate);
        context.write(new Text(""), new Text(row));
        context.getCounter("Cleaning", "rows_written").increment(1);
      }
    }
  }
}
