package g2.q2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Province {
    private final String name;

    private final List<Province> neighbours;

    public Province(String name) {
        this.name = name;
        neighbours = new ArrayList<>();
    }

    private void addNeighbour(Province province) {
        if (!neighbours.contains(province)) {
            neighbours.add(province);
        } else {
            System.out.println("省份" + this + "已经和省份" + province + "相邻");
        }
    }

    // 添加邻居省份，会为该省份和邻居省份添加同一条边
    public void addNeighbourEachOther(Province province) {
        addNeighbour(province);
        province.addNeighbour(this);
    }

    public void addNeighboursEachOther(Province... provinces) {
        for (Province province : provinces) {
            addNeighbourEachOther(province);
        }
    }

    public void findBestPathsTo(List<Province> targets) {
        List<Province> path = new ArrayList<>();
        path.add(this);

        HashMap<Province, List<Province>> bestPaths = new HashMap<>();
        for (Province target : targets) {
            bestPaths.put(target, new ArrayList<>());
        }

        bestPaths = doFindBestPathsTo(path, bestPaths);

        for (int i = 0; i < targets.size(); i++) {
            System.out.println(i + 1 + ": 目标省份：" + targets.get(i));
            System.out.print("路径：");
            for (int j = 0; j < bestPaths.get(targets.get(i)).size(); j++) {
                System.out.print(bestPaths.get(targets.get(i)).get(j));
                if (j != bestPaths.get(targets.get(i)).size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
            System.out.println("途经省份：" + (bestPaths.get(targets.get(i)).size() - 2));
            System.out.println();
        }
    }

    public HashMap<Province, List<Province>> doFindBestPathsTo(List<Province> path, HashMap<Province, List<Province>> bestPaths) {
        if (bestPaths.containsKey(this)) {
            // 如果最短路径为空，或当前路径比最短路径还短，就更新最短路径
            List<Province> bestPath = bestPaths.get(this);
            if (bestPath.isEmpty() || path.size() < bestPath.size()) {
                bestPaths.get(this).clear();
                bestPaths.get(this).addAll(path);
            }
        }

        for (Province neighbour : neighbours) {
            // 如果已经途经过这个省份，就不再走了
            if (path.contains(neighbour)) {
                continue;
            }
            path.add(neighbour);
            neighbour.doFindBestPathsTo(path, bestPaths);
            path.remove(neighbour);
        }
        return bestPaths;
    }


    @Override
    public String toString() {
        return name;
    }
}
