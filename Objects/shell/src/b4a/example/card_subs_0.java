package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class card_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim Card As Card";
card._card = RemoteObject.createNew ("b4a.example.card");__ref.setField("_card",card._card);
 //BA.debugLineNum = 4;BA.debugLine="Dim Coffeecount As Int";
card._coffeecount = RemoteObject.createImmutable(0);__ref.setField("_coffeecount",card._coffeecount);
 //BA.debugLineNum = 5;BA.debugLine="Dim img7 As Bitmap";
card._img7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");__ref.setField("_img7",card._img7);
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _coffeestamp(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("CoffeeStamp (card) ","card",2,__ref.getField(false, "ba"),__ref,12);
if (RapidSub.canDelegate("coffeestamp")) return __ref.runUserSub(false, "card","coffeestamp", __ref);
 BA.debugLineNum = 12;BA.debugLine="Sub CoffeeStamp As Int";
Debug.ShouldStop(2048);
 BA.debugLineNum = 13;BA.debugLine="Coffeecount = Coffeecount + 1 'Adds 1 stamp to cof";
Debug.ShouldStop(4096);
__ref.setField ("_coffeecount",RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_coffeecount"),RemoteObject.createImmutable(1)}, "+",1, 1));
 BA.debugLineNum = 14;BA.debugLine="Return Coffeecount ' and returns the new number of";
Debug.ShouldStop(8192);
if (true) return __ref.getField(true,"_coffeecount");
 BA.debugLineNum = 15;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (card) ","card",2,__ref.getField(false, "ba"),__ref,8);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "card","initialize", __ref, _ba);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 8;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(128);
 BA.debugLineNum = 10;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _redeem(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Redeem (card) ","card",2,__ref.getField(false, "ba"),__ref,16);
if (RapidSub.canDelegate("redeem")) return __ref.runUserSub(false, "card","redeem", __ref);
 BA.debugLineNum = 16;BA.debugLine="Sub Redeem As Boolean  'this part of code will hol";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="If Coffeecount = 6 Then ' if the person got 6 stam";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_coffeecount"),BA.numberCast(double.class, 6))) { 
 BA.debugLineNum = 18;BA.debugLine="img7.Initialize(File.DirAssets,\"free-coffee-1-2.jp";
Debug.ShouldStop(131072);
__ref.getField(false,"_img7").runVoidMethod ("Initialize",(Object)(card.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("free-coffee-1-2.jpg")));
 BA.debugLineNum = 20;BA.debugLine="Return True";
Debug.ShouldStop(524288);
if (true) return card.__c.getField(true,"True");
 };
 BA.debugLineNum = 22;BA.debugLine="Return False";
Debug.ShouldStop(2097152);
if (true) return card.__c.getField(true,"False");
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}