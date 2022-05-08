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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

}
