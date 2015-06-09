package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class data extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.data");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            if (BA.isShellModeRuntimeCheck(ba)) {
			    ba.raiseEvent2(null, true, "CREATE", true, "b4a.example.data",
                    ba);
                return;
		    }
        }
        ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public b4a.example.main _main = null;
public b4a.example.themecalc _themecalc = null;
public String  _createcard(b4a.example.data __ref,String _cardname,int _stampcount,int _bonusnumber) throws Exception{
__ref = this;
RDebugUtils.currentModule="data";
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Public Sub CreateCard(CardName As String, StampCou";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="If(File.Exists(File.DirInternal, CardName) = F";
if ((__c.File.Exists(__c.File.getDirInternal(),_cardname)==__c.False)) { 
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="File.WriteString(File.DirInternal, CardName, Stam";
__c.File.WriteString(__c.File.getDirInternal(),_cardname,BA.NumberToString(_stampcount)+","+BA.NumberToString(_bonusnumber));
 };
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="End Sub";
return "";
}
public String  _initialize(b4a.example.data __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="data";
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="End Sub";
return "";
}
public int[]  _loadcard(b4a.example.data __ref,String _cardname) throws Exception{
__ref = this;
RDebugUtils.currentModule="data";
int _bonusnumber = 0;
int _stampcount = 0;
String _carddata = "";
int _splitindex = 0;
int[] _intdata = null;
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Public Sub LoadCard(CardName As String) As Int()";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Dim BonusNumber As Int = 7 'defaults";
_bonusnumber = (int) (7);
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Dim StampCount As Int = 0";
_stampcount = (int) (0);
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="Dim cardData As String";
_carddata = "";
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="If File.Exists(File.DirInternal, CardName) = Fals";
if (__c.File.Exists(__c.File.getDirInternal(),_cardname)==__c.False) { 
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="File.WriteString(File.DirInternal, CardName, \"0,7";
__c.File.WriteString(__c.File.getDirInternal(),_cardname,"0,7");
 };
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="If(File.Exists(File.DirInternal, CardName)) Then";
if ((__c.File.Exists(__c.File.getDirInternal(),_cardname))) { 
RDebugUtils.currentLine=2293770;
 //BA.debugLineNum = 2293770;BA.debugLine="cardData = File.ReadString(File.DirInternal, Card";
_carddata = __c.File.ReadString(__c.File.getDirInternal(),_cardname);
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="Dim SplitIndex As Int = cardData.IndexOf(\",\")";
_splitindex = _carddata.indexOf(",");
RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="ToastMessageShow(cardData, True)";
__c.ToastMessageShow(_carddata,__c.True);
RDebugUtils.currentLine=2293774;
 //BA.debugLineNum = 2293774;BA.debugLine="StampCount = cardData.SubString2(0,SplitIndex)";
_stampcount = (int)(Double.parseDouble(_carddata.substring((int) (0),_splitindex)));
RDebugUtils.currentLine=2293775;
 //BA.debugLineNum = 2293775;BA.debugLine="BonusNumber = cardData.SubString(SplitIndex+1)";
_bonusnumber = (int)(Double.parseDouble(_carddata.substring((int) (_splitindex+1))));
 };
RDebugUtils.currentLine=2293778;
 //BA.debugLineNum = 2293778;BA.debugLine="Dim IntData(2) As Int";
_intdata = new int[(int) (2)];
;
RDebugUtils.currentLine=2293779;
 //BA.debugLineNum = 2293779;BA.debugLine="IntData(0) = StampCount";
_intdata[(int) (0)] = _stampcount;
RDebugUtils.currentLine=2293780;
 //BA.debugLineNum = 2293780;BA.debugLine="IntData(1) = BonusNumber";
_intdata[(int) (1)] = _bonusnumber;
RDebugUtils.currentLine=2293781;
 //BA.debugLineNum = 2293781;BA.debugLine="Return IntData";
if (true) return _intdata;
RDebugUtils.currentLine=2293782;
 //BA.debugLineNum = 2293782;BA.debugLine="End Sub";
return null;
}
public String  _savecard(b4a.example.data __ref,int _coffeecount,int _bonusnumber) throws Exception{
__ref = this;
RDebugUtils.currentModule="data";
int _countfromcard = 0;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub SaveCard(CoffeeCount As Int, BonusNumber As In";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="CoffeeCount = 1";
_coffeecount = (int) (1);
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="BonusNumber = 7";
_bonusnumber = (int) (7);
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="Dim CountFromCard As Int";
_countfromcard = 0;
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="If File.Exists(File.DirInternal, \"CoffeeCount.txt\"";
if (__c.File.Exists(__c.File.getDirInternal(),"CoffeeCount.txt")==__c.False) { 
RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="File.WriteString(File.DirInternal, \"CoffeeCount.tx";
__c.File.WriteString(__c.File.getDirInternal(),"CoffeeCount.txt",BA.NumberToString(_coffeecount));
 }else {
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="CountFromCard =    File.ReadString(File.DirInterna";
_countfromcard = (int)(Double.parseDouble(__c.File.ReadString(__c.File.getDirInternal(),"CoffeeCount.txt")));
RDebugUtils.currentLine=2162702;
 //BA.debugLineNum = 2162702;BA.debugLine="CountFromCard = CountFromCard + CoffeeCount";
_countfromcard = (int) (_countfromcard+_coffeecount);
RDebugUtils.currentLine=2162705;
 //BA.debugLineNum = 2162705;BA.debugLine="File.WriteString(File.DirInternal, \"CoffeeCount.tx";
__c.File.WriteString(__c.File.getDirInternal(),"CoffeeCount.txt",BA.NumberToString(_countfromcard));
 };
RDebugUtils.currentLine=2162712;
 //BA.debugLineNum = 2162712;BA.debugLine="End Sub";
return "";
}
}