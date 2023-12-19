package g2.q2;

import java.util.ArrayList;
import java.util.List;

public class Q2HuBei {

  public static void main(String[] args) {
    // 创建所有省份
    Province heiLongJiang = new Province("黑龙江");
    Province jiLin = new Province("吉林");
    Province liaoNing = new Province("辽宁");
    Province heBei = new Province("河北");
    Province shanXi = new Province("山西");
    Province neiMengGu = new Province("内蒙古");
    Province shanDong = new Province("山东");
    Province heNan = new Province("河南");
    Province anHui = new Province("安徽");
    Province jiangSu = new Province("江苏");
    Province shangHai = new Province("上海");
    Province zheJiang = new Province("浙江");
    Province jiangXi = new Province("江西");
    Province huBei = new Province("湖北");
    Province huNan = new Province("湖南");
    Province guangDong = new Province("广东");
    Province guangXi = new Province("广西");
    Province haiNan = new Province("海南");
    Province siChuan = new Province("四川");
    Province guiZhou = new Province("贵州");
    Province yunNan = new Province("云南");
    Province xiangGang = new Province("香港");
    Province aoMen = new Province("澳门");
    Province taiWan = new Province("台湾");
    Province chongQing = new Province("重庆");
    Province xinJiang = new Province("新疆");
    Province xiZang = new Province("西藏");
    Province ningXia = new Province("宁夏");
    Province qingHai = new Province("青海");
    Province ganSu = new Province("甘肃");
    Province shaanXi = new Province("陕西");
    Province beiJing = new Province("北京");
    Province tianJin = new Province("天津");
    Province fujian = new Province("福建");

    // addNeighbours 方法会为该省份和邻居省份添加同一条边
    // 不需要为每一条边都添加两次
    heiLongJiang.addNeighboursEachOther(jiLin, neiMengGu);
    jiLin.addNeighboursEachOther(liaoNing, neiMengGu);
    liaoNing.addNeighboursEachOther(neiMengGu, heBei);
    neiMengGu.addNeighboursEachOther(heBei, shanXi, shaanXi, ganSu, ningXia);
    heBei.addNeighboursEachOther(shanXi, beiJing, tianJin, shanDong, heNan);
    shanXi.addNeighboursEachOther(shaanXi, heNan);
    beiJing.addNeighboursEachOther(tianJin);
    tianJin.addNeighboursEachOther();
    ningXia.addNeighboursEachOther(ganSu, shaanXi);
    shaanXi.addNeighboursEachOther(ganSu, chongQing, siChuan, heNan, huBei);
    heNan.addNeighboursEachOther(huBei, anHui, shanDong);
    shanDong.addNeighboursEachOther(anHui, jiangSu);
    jiangSu.addNeighboursEachOther(anHui, zheJiang, shangHai);
    anHui.addNeighboursEachOther(zheJiang, jiangXi, huBei);
    huBei.addNeighboursEachOther(chongQing, huNan, jiangXi);
    huNan.addNeighboursEachOther(jiangXi, guangDong, guangXi, guiZhou, chongQing);
    chongQing.addNeighboursEachOther(guiZhou, siChuan);
    siChuan.addNeighboursEachOther(guiZhou, yunNan, ganSu, xiZang, qingHai);
    ganSu.addNeighboursEachOther(qingHai, xinJiang);
    qingHai.addNeighboursEachOther(xinJiang, xiZang);
    xinJiang.addNeighboursEachOther(xiZang);
    xiZang.addNeighboursEachOther(yunNan);
    yunNan.addNeighboursEachOther(guiZhou, guangXi);
    guiZhou.addNeighboursEachOther(guangXi);
    guangXi.addNeighboursEachOther(guangDong);
    guangDong.addNeighboursEachOther(haiNan, aoMen, xiangGang);
    jiangXi.addNeighboursEachOther(fujian, zheJiang);
    fujian.addNeighboursEachOther(zheJiang, taiWan);
    zheJiang.addNeighboursEachOther(shangHai);
    shangHai.addNeighboursEachOther();
    aoMen.addNeighboursEachOther(xiangGang);
    xiangGang.addNeighboursEachOther();
    taiWan.addNeighboursEachOther();
    haiNan.addNeighboursEachOther();

    // 创建所有省份的列表，除了湖北
    List<Province> allProvincesExceptHuBei = new ArrayList<>();
    allProvincesExceptHuBei.add(heiLongJiang);
    allProvincesExceptHuBei.add(jiLin);
    allProvincesExceptHuBei.add(liaoNing);
    allProvincesExceptHuBei.add(heBei);
    allProvincesExceptHuBei.add(shanXi);
    allProvincesExceptHuBei.add(neiMengGu);
    allProvincesExceptHuBei.add(shanDong);
    allProvincesExceptHuBei.add(heNan);
    allProvincesExceptHuBei.add(anHui);
    allProvincesExceptHuBei.add(jiangSu);
    allProvincesExceptHuBei.add(shangHai);
    allProvincesExceptHuBei.add(zheJiang);
    allProvincesExceptHuBei.add(jiangXi);
    allProvincesExceptHuBei.add(huNan);
    allProvincesExceptHuBei.add(guangDong);
    allProvincesExceptHuBei.add(guangXi);
    allProvincesExceptHuBei.add(haiNan);
    allProvincesExceptHuBei.add(siChuan);
    allProvincesExceptHuBei.add(guiZhou);
    allProvincesExceptHuBei.add(yunNan);
    allProvincesExceptHuBei.add(xiangGang);
    allProvincesExceptHuBei.add(aoMen);
    allProvincesExceptHuBei.add(taiWan);
    allProvincesExceptHuBei.add(chongQing);
    allProvincesExceptHuBei.add(xinJiang);
    allProvincesExceptHuBei.add(xiZang);
    allProvincesExceptHuBei.add(ningXia);
    allProvincesExceptHuBei.add(qingHai);
    allProvincesExceptHuBei.add(ganSu);
    allProvincesExceptHuBei.add(shaanXi);
    allProvincesExceptHuBei.add(beiJing);
    allProvincesExceptHuBei.add(tianJin);
    allProvincesExceptHuBei.add(fujian);

    // 找去往其他身份的最短路径
    huBei.findBestPathsTo(allProvincesExceptHuBei);
  }

}
