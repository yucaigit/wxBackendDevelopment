package com.etc.demo.menagement;

import com.etc.demo.dao.*;
import com.etc.demo.entity.*;
import com.etc.demo.service.OrderService;
import com.etc.demo.utils.SendMessageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MessageMentController {
    private static String phone=null;
    @Autowired
    GoodsDao goodsDao;

    @Autowired
    OrderService orderService;
    @Autowired
    MessageMapper messageMapper;

    @Autowired
    UsersDao usersDao;
    @Autowired
    AdressMapper adressMapper;
    @Autowired
    OrderDao orderDao;
    @Autowired
    AdminMapper adminMapper;

    @Autowired
    AttributeMapper attributeMapper;
    @RequestMapping("/mesage/login")
    public boolean login(){
        return true;
    }

    @GetMapping("/mesage/findAll")
    public PageInfo<Goods> getList(@RequestParam Integer pageNum){
        PageHelper.startPage(pageNum,3);
        List<Goods> all = goodsDao.getAll();
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(all);

        return goodsPageInfo;
    }

//管理员信息操作
    @RequestMapping("/adminLogin")
    public Boolean adminLogin(@RequestParam String name,
                              @RequestParam String password){
       Admin admin1 =  adminMapper.selectAdmin(name,password);

       if (admin1==null){
           return false;
       }else {
           return true;
       }
    }

    @RequestMapping("/mesage/selectId")
    public int selectAdminId(@RequestParam String name){
        Admin admin = adminMapper.selectId(name);
        return admin.getAdminId();
    }

    @RequestMapping("/mesage/adminUpdate")
    public Boolean adminUpdateinfo(@RequestParam Integer aid,
                                   @RequestParam String name,
                                   @RequestParam String password,
                                   @RequestParam String phone){return adminMapper.updateadmininfo(aid,name,password,phone);}


//  only update name


    @RequestMapping("/mesage/onlyUpdatename")
    public Boolean onlyUpdateName(@RequestParam Integer id,
                                  @RequestParam String name){
        return adminMapper.onlyUpdateName(id,name);
    }
//    only update pwd
    @RequestMapping("/mesage/onlyUpdatePwd")
    public Boolean onlyUpdatePwd(@RequestParam Integer id,
                                 @RequestParam String pwd){return adminMapper.onlyUpdatePwd(id,pwd);}


    @RequestMapping("/mesage/updateAdmin")
    public Boolean updateAdmin(UpdateAdmin updateAdmin){
        return adminMapper.updateAdmin(updateAdmin.getId(),updateAdmin.getName(),updateAdmin.getPwd());
    }
    @RequestMapping("/mesage/adminAdd")
    public Boolean adminAdd(Admin admin){
        return adminMapper.addAdmin(admin.getAdminName(),admin.getAdminPhone(),admin.getAdminPassword());
    }

    @RequestMapping("/changeGb")
    public boolean changeGb(@RequestParam Integer gb
    ,@RequestParam Integer gid){
        int a = gb==0?1:0;
        return goodsDao.changeGb(a,gid);
    }


    @RequestMapping("/send")
    public boolean sendMessage(){
        SendMessageUtils sendMessageUtils = new SendMessageUtils();
        JSONObject jsonObject = sendMessageUtils.sendMessage("17339876393");
        String phoneNumber = (String) jsonObject.get("phoneNumber");
        phone = phoneNumber;
        return true;
    }

    @RequestMapping("/mesage/updateGoods")
    public boolean updateGoods(Goods goods){
        return goodsDao.updateGoods(goods.getGId(),goods.getGName(),goods.getGAdress(),goods.getGDescribe());
    }
    @RequestMapping("/mesage/deleteGoods")
    public boolean deleteGoods(@RequestParam Integer gid){
        return goodsDao.deleteGoodsById(gid);}

    @RequestMapping("/getNames")
    public Set<String> getGoodsName(){return orderService.getGoodsName();}

    @RequestMapping("/getValues")
    public List<Integer> getValue(){
        Map<String, Integer> orderNum = this.getOrderNum();
        Set<String> goodsName = this.getGoodsName();
        List<Integer> list = new ArrayList<>();
        for (String str : goodsName){
            Integer integer = orderNum.get(str);
            list.add(integer);
        }
        return list;}

    @RequestMapping("/getOrderNum")
    public Map<String,Integer> getOrderNum(){
        return orderService.getOrderNum();
    }

    @RequestMapping("/message/getOrders")
    public List<ReturnOrder> getOrders(){
        return orderService.getOrders();
    }

    @RequestMapping("/message/getMessage")
    public List<Message> getmyMessage(@RequestParam Integer id){
        return messageMapper.getMyMessage(id);
    }

    @RequestMapping("/message/getAllUsers")
    public List<Users> getAlluesers(){
        return usersDao.getUser();
    }

    @RequestMapping("/mesage/getOne")
    public Order getOneOrder(@RequestParam Integer orderid){
        return orderDao.getOneOrder(orderid);}

    @RequestMapping("/mesage/getUser")
    public Users getUserByUser(@RequestParam Integer userid){return usersDao.getUserByUserId(userid);}

    @RequestMapping("/mesage/getGoods")
    public Goods getGoods(@RequestParam Integer goodsid){return goodsDao.getGoodsById(goodsid);}

    @RequestMapping("/mesage/updateUser")
    public Boolean updateUserState(@RequestParam Integer userid){return usersDao.updateUserState(userid);}

    @RequestMapping("/mesage/getUserInfo")
    public Users getUser(@RequestParam Integer uid){return usersDao.getUserByUserId(uid);}

    @RequestMapping("/mesage/getUserAdress")
    public Adress getUserAdresss(@RequestParam Integer userid){
        List<Adress> adress = adressMapper.getAdress(userid);
        Adress retun = new Adress();
        for (Adress as : adress){
            retun =as;
        }
        return retun;
    }

//    个人历史订单
    @RequestMapping("/mesage/getUserHestory")
    public List<Order> getAllOrderOne(@RequestParam Integer userid){
        List<Order> ordersByUserid = orderDao.getOrdersByUserid(userid);
        System.out.println(ordersByUserid);
        return ordersByUserid;
    }

    @RequestMapping("/mesage/getattrbute")
    public List<String> getAllNameOfattribu(){return attributeMapper.getAllName();}

//    根据商品名称搜索
    @RequestMapping("/mesage/getGoodsByName")
    public Goods getGoodsByn(@RequestParam String gName){return goodsDao.getGoodsByName(gName);}

    //根据类别搜索
    @RequestMapping("/mesage/getGoodsByattr")
    public List<Goods> getGoodsByattr(@RequestParam String aName){
        int gAttributes = attributeMapper.getAllId(aName);
        List<Goods> goodsList = goodsDao.getAllGoodsByAid(gAttributes);
        return goodsList;
    }
    @RequestMapping("/mesage/getUserName")
    public String getUserName(@RequestParam Integer uid){
        return usersDao.getOneName(uid);
    }
    @RequestMapping("/mesage/getGoodsnameAttr")
    public Goods getOneByttandGName(@RequestParam String attr,
                                    @RequestParam String gName){
        int id = attributeMapper.getAllId(attr);
        Goods one = goodsDao.getOneGoods(id,gName);
        return null;
    }
//    得到用户数量 商品数量 订单数量
    @RequestMapping("/mesage/getUsersNum")
    public int getUserNumss(){
        List<Users> user = usersDao.getUser();
        return user.size();
    }
    @RequestMapping("/mesage/getGoodsNum")
    public int getUserNumO(){
        List<Goods> all = goodsDao.getAll();
        return all.size();
    }
    @RequestMapping("/mesage/getOrderNum")
    public int getOrderNums(){
        List<ReturnOrder> orders = orderDao.getOrders();
        return orders.size();
    }

//    @RequestMapping("/mesage/getOrderSucc")
//    public int getsuccessOrderNum(){
//         orderDao.getsuccessOrder();
//    }
    @RequestMapping("/mesage/getallMoney")
    public int getAllMoney(){
        int money =0;

        List<Order> list = orderDao.getAllOrder();
        for (Order o: list){
            money += o.getOrderAmount()*Integer.parseInt(o.getGoods().getGPrice());
        }
        return money;
    }
//    得到所有订单
    @RequestMapping("/mesage/getOrderCunt")
    public int getOrderCount(){return orderDao.getOrderCunt();}

//    修改用户状态
    @RequestMapping("/mesage/updateUserState")
    public boolean updateUserStateIsZ(
            @RequestParam Integer uid
    ){return usersDao.updateUserStateIsZ(uid);}

    @RequestMapping("/mesage/getSort")
    public List<Attribute> getSortList(){return attributeMapper.getAllSort();}

//    分类详情
    @RequestMapping("/mesage/getSortDetail")
    public Attribute getSortDetail(@RequestParam Integer aid){return attributeMapper.getSortDetail(aid);
    }
    @RequestMapping("/mesage/getSortNum")
    public int getSortNum(@RequestParam Integer aid){
        return goodsDao.getNum(aid);
    }
    @RequestMapping("/mesage/getSortAGoods")
    public List<Goods> getSortAGoods(@RequestParam Integer aid){return goodsDao.getAllGoodsByAid(aid);}

    @RequestMapping("/mesage/isExitSort")
    public Boolean isExitSort(@RequestParam String name){return attributeMapper.isExitSo(name);}

    @RequestMapping("/mesage/addSort")
    public Boolean addSortN(@RequestParam String name){return attributeMapper.addSort(name);}

    @RequestMapping("/mesage/deleteSort")
    public Boolean deleteSort(@RequestParam Integer aid){return attributeMapper.deleteSort(aid);}

    @RequestMapping("/mesage/deleteOrder")
    public Boolean deleteOrderById(@RequestParam Integer oid){return orderDao.deleteOrder(oid);}

    @RequestMapping("/mesage/updateSort")
    public Boolean updateSortName(@RequestParam Integer aid,
            @RequestParam String name){return attributeMapper.updateSortName(aid,name);}

    @RequestMapping("/mesage/updateGoodsAtt")
    public Boolean updateGoodsAtt(@RequestParam Integer gid,
                                  @RequestParam String name){
        int attrid = attributeMapper.selectIdByName(name);
//        修改商品attrid
        return goodsDao.updateGoodsAttr(gid,attrid);
    }

    @RequestMapping("/mesage/deleteGoodsT")
    public Boolean deleteGoodsTr(@RequestParam Integer gid){
        return goodsDao.deleteGoodsTrue(gid);
    }
}
