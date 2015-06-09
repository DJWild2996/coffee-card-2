package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class coffeestamp_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim ShopName As String";
coffeestamp._shopname = RemoteObject.createImmutable("");__ref.setField("_shopname",coffeestamp._shopname);
 //BA.debugLineNum = 4;BA.debugLine="Dim StampID As String";
coffeestamp._stampid = RemoteObject.createImmutable("");__ref.setField("_stampid",coffeestamp._stampid);
 //BA.debugLineNum = 5;BA.debugLine="Dim Date As Int";
coffeestamp._date = RemoteObject.createImmutable(0);__ref.setField("_date",coffeestamp._date);
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (coffeestamp) ","coffeestamp",3,__ref.getField(false, "ba"),__ref,9);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "coffeestamp","initialize", __ref, _ba);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 9;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(256);
 BA.debugLineNum = 11;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}