package assignment3.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import assignment3.structs.Edge;

public class Util {
    public static List<Map<String, Object>> edgesToList(List<Edge> edges) {
        // normalize edges so from <= to lexicographically, then sort by weight, then from, then to
        List<Edge> copy = new ArrayList<>();
        for (Edge e : edges) {
            String a = e.from;
            String b = e.to;
            if (a.compareTo(b) <= 0) copy.add(new Edge(a, b, e.weight));
            else copy.add(new Edge(b, a, e.weight));
        }
        copy.sort(java.util.Comparator.comparingInt((Edge e) -> e.weight)
                .thenComparing(e -> e.from)
                .thenComparing(e -> e.to));
        List<Map<String, Object>> list = new ArrayList<>();
        for (Edge e : copy) {
            Map<String, Object> m = new LinkedHashMap<>();
            m.put("from", e.from);
            m.put("to", e.to);
            m.put("weight", e.weight);
            list.add(m);
        }
        return list;
    }

    public static double round(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    // minimal JSON writer for the expected structure
    public static String toJson(List<Map<String, Object>> results) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n  \"results\": [\n");
        for (int i = 0; i < results.size(); i++) {
            Map<String, Object> r = results.get(i);
            sb.append("    {");
            sb.append("\n      \"graph_id\": ").append(r.get("graph_id")).append(",\n");
            sb.append("      \"input_stats\": {\n");
            Map<String,Integer> stats = (Map<String,Integer>)r.get("input_stats");
            sb.append("        \"vertices\": ").append(stats.get("vertices")).append(",\n");
            sb.append("        \"edges\": ").append(stats.get("edges")).append("\n");
            sb.append("      },\n");

            sb.append("      \"prim\": {").append("\n");
            Map<String,Object> prim = (Map<String,Object>)r.get("prim");
            sb.append(writeAlg(prim));
            sb.append("      },\n");

            sb.append("      \"kruskal\": {\n");
            Map<String,Object> kr = (Map<String,Object>)r.get("kruskal");
            sb.append(writeAlg(kr));
            sb.append("      }\n");

            sb.append("    }");
            if (i < results.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("  ]\n}");
        return sb.toString();
    }

    public static String writeAlg(Map<String,Object> alg) {
        StringBuilder sb = new StringBuilder();
        sb.append("        \"mst_edges\": [\n");
        List<Map<String,Object>> edges = (List<Map<String,Object>>)alg.get("mst_edges");
        for (int i = 0; i < edges.size(); i++) {
            Map<String,Object> e = edges.get(i);
            sb.append("          {");
            sb.append("\"from\": \"").append(e.get("from")).append("\", ");
            sb.append("\"to\": \"").append(e.get("to")).append("\", ");
            sb.append("\"weight\": ").append(e.get("weight")).append("}");
            if (i < edges.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("        ],\n");
        sb.append("        \"total_cost\": ").append(alg.get("total_cost")).append(",\n");
        sb.append("        \"operations_count\": ").append(alg.get("operations_count")).append(",\n");
        sb.append("        \"execution_time_ms\": ").append(alg.get("execution_time_ms")).append("\n");
        return sb.toString();
    }
}
