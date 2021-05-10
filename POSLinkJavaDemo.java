import java.util.*;
import com.pax.*;

class FeedServer {
    public static void main(String args[]) throws IOException {
        CommSetting commSetting = new CommSetting();
        commSetting .setType(CommSetting.TCP);
        commSetting .setDestIP("192.168.000.101");
        commSetting .setDestPort("10009");
        commSetting .setTimeOut("20000");
        PosLink poslink = new PosLink();
        poslink.SetCommSetting(commSetting);
        //////////////////MANAGE COMMAND START///////////////////////////////
        ManageRequest manageReq = new ManageRequest();
        manageReq.TransType = manageReq.ParseTransType("INIT");
        poslink.ManageRequest = manageReq;
        ProcessTransResult transResult = poslink.ProcessTrans();
        System.out.println(transResult.Code + ":" + transResult.Msg);
        ManageResponse manageRes = poslink.ManageResponse;
        if (r != null) System.out.println(manageRes.ResultCode + " - " + manageRes.ResultTxt
        + "\r\nSN: " + manageRes.SN
        + "\r\nModel Name: " + manageRes.ModelName
        + "\r\nOS Version: " + manageRes.OSVersion
        + "\r\nMac Address: " + manageRes.MacAddress
        + "\r\nLines Per Screen: " + manageRes.LinesPerScreen
        + "\r\nCharsPerLine: " + manageRes.CharsPerLine);
    }
}