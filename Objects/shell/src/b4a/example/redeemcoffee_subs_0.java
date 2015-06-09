package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class redeemcoffee_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Dim random As Int";
redeemcoffee._random = RemoteObject.createImmutable(0);__ref.setField("_random",redeemcoffee._random);
 //BA.debugLineNum = 4;BA.debugLine="Dim ImageViews1 As ImageView";
redeemcoffee._imageviews1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");__ref.setField("_imageviews1",redeemcoffee._imageviews1);
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (redeemcoffee) ","redeemcoffee",6,__ref.getField(false, "ba"),__ref,8);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "redeemcoffee","initialize", __ref, _ba);
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
		Debug.PushSubsStack("redeem (redeemcoffee) ","redeemcoffee",6,__ref.getField(false, "ba"),__ref,11);
if (RapidSub.canDelegate("redeem")) return __ref.runUserSub(false, "redeemcoffee","redeem", __ref);
 BA.debugLineNum = 11;BA.debugLine="public Sub redeem";
Debug.ShouldStop(1024);
 BA.debugLineNum = 12;BA.debugLine="If redeem = 1 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",__ref.runClassMethod (b4a.example.redeemcoffee.class, "_redeem"),BA.NumberToString(1))) { 
 BA.debugLineNum = 13;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"1";
Debug.ShouldStop(4096);
__ref.getField(false,"_imageviews1").runMethod(false,"setBitmap",(redeemcoffee.__c.runMethod(false,"LoadBitmap",(Object)(redeemcoffee.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("1.jpg"))).getObject()));
 };
 BA.debugLineNum = 15;BA.debugLine="If redeem = 2 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",__ref.runClassMethod (b4a.example.redeemcoffee.class, "_redeem"),BA.NumberToString(2))) { 
 BA.debugLineNum = 16;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"2";
Debug.ShouldStop(32768);
__ref.getField(false,"_imageviews1").runMethod(false,"setBitmap",(redeemcoffee.__c.runMethod(false,"LoadBitmap",(Object)(redeemcoffee.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("2.jpg"))).getObject()));
 };
 BA.debugLineNum = 18;BA.debugLine="If redeem = 3 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",__ref.runClassMethod (b4a.example.redeemcoffee.class, "_redeem"),BA.NumberToString(3))) { 
 BA.debugLineNum = 19;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"3";
Debug.ShouldStop(262144);
__ref.getField(false,"_imageviews1").runMethod(false,"setBitmap",(redeemcoffee.__c.runMethod(false,"LoadBitmap",(Object)(redeemcoffee.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("3.png"))).getObject()));
 };
 BA.debugLineNum = 21;BA.debugLine="If redeem = 4 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",__ref.runClassMethod (b4a.example.redeemcoffee.class, "_redeem"),BA.NumberToString(4))) { 
 BA.debugLineNum = 22;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"4";
Debug.ShouldStop(2097152);
__ref.getField(false,"_imageviews1").runMethod(false,"setBitmap",(redeemcoffee.__c.runMethod(false,"LoadBitmap",(Object)(redeemcoffee.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("4.png"))).getObject()));
 };
 BA.debugLineNum = 24;BA.debugLine="If redeem = 5 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",__ref.runClassMethod (b4a.example.redeemcoffee.class, "_redeem"),BA.NumberToString(5))) { 
 BA.debugLineNum = 25;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"5";
Debug.ShouldStop(16777216);
__ref.getField(false,"_imageviews1").runMethod(false,"setBitmap",(redeemcoffee.__c.runMethod(false,"LoadBitmap",(Object)(redeemcoffee.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("5.png"))).getObject()));
 };
 BA.debugLineNum = 27;BA.debugLine="If redeem = 6 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",__ref.runClassMethod (b4a.example.redeemcoffee.class, "_redeem"),BA.NumberToString(6))) { 
 BA.debugLineNum = 28;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"6";
Debug.ShouldStop(134217728);
__ref.getField(false,"_imageviews1").runMethod(false,"setBitmap",(redeemcoffee.__c.runMethod(false,"LoadBitmap",(Object)(redeemcoffee.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("6.png"))).getObject()));
 };
 BA.debugLineNum = 30;BA.debugLine="If redeem = 7 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",__ref.runClassMethod (b4a.example.redeemcoffee.class, "_redeem"),BA.NumberToString(7))) { 
 BA.debugLineNum = 31;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"7";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_imageviews1").runMethod(false,"setBitmap",(redeemcoffee.__c.runMethod(false,"LoadBitmap",(Object)(redeemcoffee.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("7.png"))).getObject()));
 };
 BA.debugLineNum = 33;BA.debugLine="If redeem= 8 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",__ref.runClassMethod (b4a.example.redeemcoffee.class, "_redeem"),BA.NumberToString(8))) { 
 BA.debugLineNum = 34;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"8";
Debug.ShouldStop(2);
__ref.getField(false,"_imageviews1").runMethod(false,"setBitmap",(redeemcoffee.__c.runMethod(false,"LoadBitmap",(Object)(redeemcoffee.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("8.png"))).getObject()));
 };
 BA.debugLineNum = 36;BA.debugLine="random = redeem";
Debug.ShouldStop(8);
__ref.setField ("_random",BA.numberCast(int.class, __ref.runClassMethod (b4a.example.redeemcoffee.class, "_redeem")));
 BA.debugLineNum = 37;BA.debugLine="random = Rnd(1, 9)";
Debug.ShouldStop(16);
__ref.setField ("_random",redeemcoffee.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 9))));
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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