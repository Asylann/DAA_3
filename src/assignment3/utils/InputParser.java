package assignment3.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import assignment3.structs.Edge;
import assignment3.structs.Graph;

public class InputParser {
    public static List<Graph> parse(String filePath) throws IOException {
        String s = new String(Files.readAllBytes(Paths.get(filePath)), java.nio.charset.StandardCharsets.UTF_8);

        List<Graph> graphs = new ArrayList<>();
        String gArray = s.substring(s.indexOf("["), s.lastIndexOf("]") + 1);
        String[] items = gArray.split("\\n\\s*\\},\\s*\\{");
        for (String item : items) {
            if (!item.contains("\"nodes\"")) continue;
            // nodes
            int ni = item.indexOf("\"nodes\"");
            int nstart = item.indexOf('[', ni);
            int nend = item.indexOf(']', nstart);
            String nodesRaw = item.substring(nstart + 1, nend).replaceAll("[\"\s]", "");
            List<String> nodes = nodesRaw.isEmpty() ? new ArrayList<>() : Arrays.asList(nodesRaw.split(","));

            // edges
            List<Edge> edges = new ArrayList<>();
            int ei = item.indexOf("\"edges\"");
            if (ei >= 0) {
                int estart = item.indexOf('[', ei);
                int eend = item.indexOf(']', estart);
                String edgesRaw = item.substring(estart + 1, eend);
                String[] es = edgesRaw.split("\\},\\s*\\{");
                for (String eitem : es) {
                    String e = eitem.replaceAll("[\\{\\}\\[\\]\\n\\r]", "");
                    String from = extractString(e, "from");
                    String to = extractString(e, "to");
                    int w = Integer.parseInt(extractString(e, "weight"));
                    edges.add(new Edge(from, to, w));
                }
            }
            graphs.add(new Graph(nodes, edges));
        }
        return graphs;
    }

    private static String extractString(String s, String key) {
        int ki = s.indexOf('"' + key + '"');
        if (ki < 0) ki = s.indexOf(key);
        int colon = s.indexOf(':', ki);
        int comma = s.indexOf(',', colon);
        if (comma < 0) comma = s.length();
        String val = s.substring(colon + 1, comma).trim();
        val = val.replaceAll("\"", "");
        return val;
    }
}
