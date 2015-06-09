package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class data_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _createcard(RemoteObject __ref,RemoteObject _cardname,RemoteObject _stampcount,RemoteObject _bonusnumber) throws Exception{
try {
		Debug.PushSubsStack("CreateCard (data) ","data",5,__ref.getField(false, "ba"),__ref,40);
if (RapidSub.canDelegate("createcard")) return __ref.runUserSub(false, "data","createcard", __ref, _cardname, _stampcount, _bonusnumber);
Debug.locals.put("CardName", _cardname);
Debug.locals.put("StampCount", _stampcount);
Debug.locals.put("BonusNumber", _bonusnumber);
 BA.debugLineNum = 40;BA.debugLine="Public Sub CreateCard(CardName As String, StampCou";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="If(File.Exists(File.DirInternal, CardName) = F";
Debug.ShouldStop(256);
if ((RemoteObject.solveBoolean("=",data.__c.getField(false,"File").runMethod(true,"Exists",(Object)(data.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_cardname)),data.__c.getField(true,"False")))) { 
 BA.debugLineNum = 42;BA.debugLine="File.WriteString(File.DirInternal, CardName, Stam";
Debug.ShouldStop(512);
data.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(data.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_cardname),(Object)(RemoteObject.concat(_stampcount,RemoteObject.createImmutable(","),_bonusnumber)));
 };
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
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
		Debug.PushSubsStack("Initialize (data) ","data",5,__ref.getField(false, "ba"),__ref,8);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "data","initialize", __ref, _ba);
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
public static RemoteObject  _loadcard(RemoteObject __ref,RemoteObject _cardname) throws Exception{
try {
		Debug.PushSubsStack("LoadCard (data) ","data",5,__ref.getField(false, "ba"),__ref,47);
if (RapidSub.canDelegate("loadcard")) return __ref.runUserSub(false, "data","loadcard", __ref, _cardname);
RemoteObject _bonusnumber = RemoteObject.createImmutable(0);
RemoteObject _stampcount = RemoteObject.createImmutable(0);
RemoteObject _carddata = RemoteObject.createImmutable("");
RemoteObject _splitindex = RemoteObject.createImmutable(0);
RemoteObject _intdata = null;
Debug.locals.put("CardName", _cardname);
 BA.debugLineNum = 47;BA.debugLine="Public Sub LoadCard(CardName As String) As Int()";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Dim BonusNumber As Int = 7 'defaults";
Debug.ShouldStop(32768);
_bonusnumber = BA.numberCast(int.class, 7);Debug.locals.put("BonusNumber", _bonusnumber);Debug.locals.put("BonusNumber", _bonusnumber);
 BA.debugLineNum = 49;BA.debugLine="Dim StampCount As Int = 0";
Debug.ShouldStop(65536);
_stampcount = BA.numberCast(int.class, 0);Debug.locals.put("StampCount", _stampcount);Debug.locals.put("StampCount", _stampcount);
 BA.debugLineNum = 50;BA.debugLine="Dim cardData As String";
Debug.ShouldStop(131072);
_carddata = RemoteObject.createImmutable("");Debug.locals.put("cardData", _carddata);
 BA.debugLineNum = 52;BA.debugLine="If File.Exists(File.DirInternal, CardName) = Fals";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",data.__c.getField(false,"File").runMethod(true,"Exists",(Object)(data.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_cardname)),data.__c.getField(true,"False"))) { 
 BA.debugLineNum = 53;BA.debugLine="File.WriteString(File.DirInternal, CardName, \"0,7";
Debug.ShouldStop(1048576);
data.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(data.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_cardname),(Object)(RemoteObject.createImmutable("0,7")));
 };
 BA.debugLineNum = 56;BA.debugLine="If(File.Exists(File.DirInternal, CardName)) Then";
Debug.ShouldStop(8388608);
if ((data.__c.getField(false,"File").runMethod(true,"Exists",(Object)(data.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_cardname))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 57;BA.debugLine="cardData = File.ReadString(File.DirInternal, Card";
Debug.ShouldStop(16777216);
_carddata = data.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(data.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(_cardname));Debug.locals.put("cardData", _carddata);
 BA.debugLineNum = 58;BA.debugLine="Dim SplitIndex As Int = cardData.IndexOf(\",\")";
Debug.ShouldStop(33554432);
_splitindex = _carddata.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(",")));Debug.locals.put("SplitIndex", _splitindex);Debug.locals.put("SplitIndex", _splitindex);
 BA.debugLineNum = 60;BA.debugLine="ToastMessageShow(cardData, True)";
Debug.ShouldStop(134217728);
data.__c.runVoidMethod ("ToastMessageShow",(Object)(_carddata),(Object)(data.__c.getField(true,"True")));
 BA.debugLineNum = 61;BA.debugLine="StampCount = cardData.SubString2(0,SplitIndex)";
Debug.ShouldStop(268435456);
_stampcount = BA.numberCast(int.class, _carddata.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(_splitindex)));Debug.locals.put("StampCount", _stampcount);
 BA.debugLineNum = 62;BA.debugLine="BonusNumber = cardData.SubString(SplitIndex+1)";
Debug.ShouldStop(536870912);
_bonusnumber = BA.numberCast(int.class, _carddata.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_splitindex,RemoteObject.createImmutable(1)}, "+",1, 1))));Debug.locals.put("BonusNumber", _bonusnumber);
 };
 BA.debugLineNum = 65;BA.debugLine="Dim IntData(2) As Int";
Debug.ShouldStop(1);
_intdata = RemoteObject.createNewArray ("int", new int[] {2}, new Object[]{});Debug.locals.put("IntData", _intdata);
 BA.debugLineNum = 66;BA.debugLine="IntData(0) = StampCount";
Debug.ShouldStop(2);
_intdata.setArrayElement (_stampcount,BA.numberCast(int.class, 0));
 BA.debugLineNum = 67;BA.debugLine="IntData(1) = BonusNumber";
Debug.ShouldStop(4);
_intdata.setArrayElement (_bonusnumber,BA.numberCast(int.class, 1));
 BA.debugLineNum = 68;BA.debugLine="Return IntData";
Debug.ShouldStop(8);
if (true) return _intdata;
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savecard(RemoteObject __ref,RemoteObject _coffeecount,RemoteObject _bonusnumber) throws Exception{
try {
		Debug.PushSubsStack("SaveCard (data) ","data",5,__ref.getField(false, "ba"),__ref,13);
if (RapidSub.canDelegate("savecard")) return __ref.runUserSub(false, "data","savecard", __ref, _coffeecount, _bonusnumber);
RemoteObject _countfromcard = RemoteObject.createImmutable(0);
Debug.locals.put("CoffeeCount", _coffeecount);
Debug.locals.put("BonusNumber", _bonusnumber);
 BA.debugLineNum = 13;BA.debugLine="Sub SaveCard(CoffeeCount As Int, BonusNumber As In";
Debug.ShouldStop(4096);
 BA.debugLineNum = 14;BA.debugLine="CoffeeCount = 1";
Debug.ShouldStop(8192);
_coffeecount = BA.numberCast(int.class, 1);Debug.locals.put("CoffeeCount", _coffeecount);
 BA.debugLineNum = 15;BA.debugLine="BonusNumber = 7";
Debug.ShouldStop(16384);
_bonusnumber = BA.numberCast(int.class, 7);Debug.locals.put("BonusNumber", _bonusnumber);
 BA.debugLineNum = 16;BA.debugLine="Dim CountFromCard As Int";
Debug.ShouldStop(32768);
_countfromcard = RemoteObject.createImmutable(0);Debug.locals.put("CountFromCard", _countfromcard);
 BA.debugLineNum = 19;BA.debugLine="If File.Exists(File.DirInternal, \"CoffeeCount.txt\"";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",data.__c.getField(false,"File").runMethod(true,"Exists",(Object)(data.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("CoffeeCount.txt"))),data.__c.getField(true,"False"))) { 
 BA.debugLineNum = 20;BA.debugLine="File.WriteString(File.DirInternal, \"CoffeeCount.tx";
Debug.ShouldStop(524288);
data.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(data.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("CoffeeCount.txt")),(Object)(BA.NumberToString(_coffeecount)));
 }else {
 BA.debugLineNum = 24;BA.debugLine="CountFromCard =    File.ReadString(File.DirInterna";
Debug.ShouldStop(8388608);
_countfromcard = BA.numberCast(int.class, data.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(data.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("CoffeeCount.txt"))));Debug.locals.put("CountFromCard", _countfromcard);
 BA.debugLineNum = 27;BA.debugLine="CountFromCard = CountFromCard + CoffeeCount";
Debug.ShouldStop(67108864);
_countfromcard = RemoteObject.solve(new RemoteObject[] {_countfromcard,_coffeecount}, "+",1, 1);Debug.locals.put("CountFromCard", _countfromcard);
 BA.debugLineNum = 30;BA.debugLine="File.WriteString(File.DirInternal, \"CoffeeCount.tx";
Debug.ShouldStop(536870912);
data.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(data.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("CoffeeCount.txt")),(Object)(BA.NumberToString(_countfromcard)));
 };
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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