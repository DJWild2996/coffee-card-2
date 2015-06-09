package b4a.example;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class redeemcoffee extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "b4a.example.redeemcoffee");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            if (BA.isShellModeRuntimeCheck(ba)) {
			    ba.raiseEvent2(null, true, "CREATE", true, "b4a.example.redeemcoffee",
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
public int _random = 0;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageviews1 = null;
public b4a.example.main _main = null;
public b4a.example.themecalc _themecalc = null;
public String  _initialize(b4a.example.redeemcoffee __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="redeemcoffee";
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="End Sub";
return "";
}
public String  _redeem(b4a.example.redeemcoffee __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="redeemcoffee";
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="public Sub redeem";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="If redeem = 1 Then";
if ((__ref._redeem(null)).equals(BA.NumberToString(1))) { 
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"1";
__ref._imageviews1.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"1.jpg").getObject()));
 };
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="If redeem = 2 Then";
if ((__ref._redeem(null)).equals(BA.NumberToString(2))) { 
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"2";
__ref._imageviews1.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"2.jpg").getObject()));
 };
RDebugUtils.currentLine=4194311;
 //BA.debugLineNum = 4194311;BA.debugLine="If redeem = 3 Then";
if ((__ref._redeem(null)).equals(BA.NumberToString(3))) { 
RDebugUtils.currentLine=4194312;
 //BA.debugLineNum = 4194312;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"3";
__ref._imageviews1.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"3.png").getObject()));
 };
RDebugUtils.currentLine=4194314;
 //BA.debugLineNum = 4194314;BA.debugLine="If redeem = 4 Then";
if ((__ref._redeem(null)).equals(BA.NumberToString(4))) { 
RDebugUtils.currentLine=4194315;
 //BA.debugLineNum = 4194315;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"4";
__ref._imageviews1.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"4.png").getObject()));
 };
RDebugUtils.currentLine=4194317;
 //BA.debugLineNum = 4194317;BA.debugLine="If redeem = 5 Then";
if ((__ref._redeem(null)).equals(BA.NumberToString(5))) { 
RDebugUtils.currentLine=4194318;
 //BA.debugLineNum = 4194318;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"5";
__ref._imageviews1.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"5.png").getObject()));
 };
RDebugUtils.currentLine=4194320;
 //BA.debugLineNum = 4194320;BA.debugLine="If redeem = 6 Then";
if ((__ref._redeem(null)).equals(BA.NumberToString(6))) { 
RDebugUtils.currentLine=4194321;
 //BA.debugLineNum = 4194321;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"6";
__ref._imageviews1.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"6.png").getObject()));
 };
RDebugUtils.currentLine=4194323;
 //BA.debugLineNum = 4194323;BA.debugLine="If redeem = 7 Then";
if ((__ref._redeem(null)).equals(BA.NumberToString(7))) { 
RDebugUtils.currentLine=4194324;
 //BA.debugLineNum = 4194324;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"7";
__ref._imageviews1.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"7.png").getObject()));
 };
RDebugUtils.currentLine=4194326;
 //BA.debugLineNum = 4194326;BA.debugLine="If redeem= 8 Then";
if ((__ref._redeem(null)).equals(BA.NumberToString(8))) { 
RDebugUtils.currentLine=4194327;
 //BA.debugLineNum = 4194327;BA.debugLine="ImageViews1.Bitmap = LoadBitmap(File.DirAssets, \"8";
__ref._imageviews1.setBitmap((android.graphics.Bitmap)(__c.LoadBitmap(__c.File.getDirAssets(),"8.png").getObject()));
 };
RDebugUtils.currentLine=4194329;
 //BA.debugLineNum = 4194329;BA.debugLine="random = redeem";
__ref._random = (int)(Double.parseDouble(__ref._redeem(null)));
RDebugUtils.currentLine=4194330;
 //BA.debugLineNum = 4194330;BA.debugLine="random = Rnd(1, 9)";
__ref._random = __c.Rnd((int) (1),(int) (9));
RDebugUtils.currentLine=4194332;
 //BA.debugLineNum = 4194332;BA.debugLine="End Sub";
return "";
}
}