package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
		BA.handler.postDelayed(new WaitForLayout(), 5);

	}
	private static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = main.mostCurrent.processBA.sharedProcessBA.activityBA.get();
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _mycolors = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _mylogo = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _myconame = null;
public static anywheresoftware.b4a.sql.SQL.CursorWrapper _mystamp = null;
public b4a.example.card _card = null;
public static int _coffeecount = 0;
public static String _mresult = "";
public anywheresoftware.b4a.objects.ButtonWrapper _btnscan = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imglogo = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgstamp1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgstamp2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgstamp3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgstamp4 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgstamp5 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgstamp6 = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblcompanyname = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlbg = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlstamp1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlstamp2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlstamp3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlstamp4 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlstamp5 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlstamp6 = null;
public b4a.example.coffeetheme _mytheme = null;
public static boolean _scansuccess = false;
public ice.zxing.b4aZXingLib _qrscanner = null;
public com.AB.ABZxing.ABZxing _myabbarcode = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public b4a.example.themecalc _themecalc = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Activity.LoadLayout(\"main\")";
mostCurrent._activity.LoadLayout("main",mostCurrent.activityBA);
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="myTheme.Initialize ' initialise theme database on";
mostCurrent._mytheme._initialize(null,processBA);
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="loadDBcolours";
_loaddbcolours();
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="loadDBlogo";
_loaddblogo();
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="loadDBname";
_loaddbname();
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="loadStamp";
_loadstamp();
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="End Sub";
return "";
}
public static String  _loaddbcolours() throws Exception{
RDebugUtils.currentModule="main";
int _i = 0;
anywheresoftware.b4a.objects.drawable.GradientDrawable _bggradient = null;
int[] _colours = null;
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub loadDBcolours 'Load background colours from da";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="myColors = myTheme.loadColours";
_mycolors = mostCurrent._mytheme._loadcolours(null);
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="For i = 0 To myColors.RowCount - 1 '";
{
final int step33 = 1;
final int limit33 = (int) (_mycolors.getRowCount()-1);
for (_i = (int) (0); (step33 > 0 && _i <= limit33) || (step33 < 0 && _i >= limit33); _i = ((int)(0 + _i + step33))) {
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="myColors.Position = i";
_mycolors.setPosition(_i);
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="Dim bgGradient As GradientDrawable";
_bggradient = new anywheresoftware.b4a.objects.drawable.GradientDrawable();
RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="Dim colours(2) As Int";
_colours = new int[(int) (2)];
;
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="colours(0) = Colors.RGB(myColors.GetInt(\"BG1Red\"";
_colours[(int) (0)] = anywheresoftware.b4a.keywords.Common.Colors.RGB(_mycolors.GetInt("BG1Red"),_mycolors.GetInt("BG1Blue"),_mycolors.GetInt("BG1Green"));
RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="colours(1) = Colors.RGB(myColors.GetInt(\"BG2Red\"";
_colours[(int) (1)] = anywheresoftware.b4a.keywords.Common.Colors.RGB(_mycolors.GetInt("BG2Red"),_mycolors.GetInt("BG2Blue"),_mycolors.GetInt("BG2Green"));
RDebugUtils.currentLine=196616;
 //BA.debugLineNum = 196616;BA.debugLine="bgGradient.Initialize(\"TR_BL\", colours)";
_bggradient.Initialize(BA.getEnumFromString(android.graphics.drawable.GradientDrawable.Orientation.class,"TR_BL"),_colours);
RDebugUtils.currentLine=196617;
 //BA.debugLineNum = 196617;BA.debugLine="pnlBG.Background=bgGradient";
mostCurrent._pnlbg.setBackground((android.graphics.drawable.Drawable)(_bggradient.getObject()));
 }
};
RDebugUtils.currentLine=196619;
 //BA.debugLineNum = 196619;BA.debugLine="End Sub";
return "";
}
public static String  _loaddblogo() throws Exception{
RDebugUtils.currentModule="main";
int _i = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _image = null;
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub loadDBlogo 'Load Logo as string from database";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="myLogo=myTheme.loadLogo";
_mylogo = mostCurrent._mytheme._loadlogo(null);
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="For i = 0 To myLogo.RowCount - 1";
{
final int step45 = 1;
final int limit45 = (int) (_mylogo.getRowCount()-1);
for (_i = (int) (0); (step45 > 0 && _i <= limit45) || (step45 < 0 && _i >= limit45); _i = ((int)(0 + _i + step45))) {
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="myLogo.Position=i";
_mylogo.setPosition(_i);
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Dim image As Bitmap";
_image = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="image.Initialize(File.DirAssets, myLogo.GetStrin";
_image.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_mylogo.GetString("Logo"));
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="imgLogo.Bitmap=image";
mostCurrent._imglogo.setBitmap((android.graphics.Bitmap)(_image.getObject()));
 }
};
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="End Sub";
return "";
}
public static String  _loaddbname() throws Exception{
RDebugUtils.currentModule="main";
int _i = 0;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub loadDBname 'Load company name from database";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="myCoName=myTheme.loadCompanyName";
_myconame = mostCurrent._mytheme._loadcompanyname(null);
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="For i = 0 To myCoName.RowCount - 1";
{
final int step54 = 1;
final int limit54 = (int) (_myconame.getRowCount()-1);
for (_i = (int) (0); (step54 > 0 && _i <= limit54) || (step54 < 0 && _i >= limit54); _i = ((int)(0 + _i + step54))) {
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="myCoName.Position=i";
_myconame.setPosition(_i);
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="lblCompanyName.Text  =myCoName.GetString(\"Compan";
mostCurrent._lblcompanyname.setText((Object)(_myconame.GetString("CompanyName")));
 }
};
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="End Sub";
return "";
}
public static String  _loadstamp() throws Exception{
RDebugUtils.currentModule="main";
int _i = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _image = null;
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub loadStamp 'load stamp from database";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="myStamp=myTheme.loadStampIcon";
_mystamp = mostCurrent._mytheme._loadstampicon(null);
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="For i = 0 To myStamp.RowCount - 1";
{
final int step61 = 1;
final int limit61 = (int) (_mystamp.getRowCount()-1);
for (_i = (int) (0); (step61 > 0 && _i <= limit61) || (step61 < 0 && _i >= limit61); _i = ((int)(0 + _i + step61))) {
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="myStamp.Position=i";
_mystamp.setPosition(_i);
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="Dim image As Bitmap";
_image = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=393221;
 //BA.debugLineNum = 393221;BA.debugLine="image.Initialize(File.DirAssets, myLogo.GetStrin";
_image.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),_mylogo.GetString("StampIcon"));
RDebugUtils.currentLine=393222;
 //BA.debugLineNum = 393222;BA.debugLine="imgStamp1.Bitmap=image";
mostCurrent._imgstamp1.setBitmap((android.graphics.Bitmap)(_image.getObject()));
 }
};
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
public static String  _btnscan_click() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub btnScan_Click 'in order to bring information a";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="updateStamps";
_updatestamps();
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="End Sub";
return "";
}
public static String  _updatestamps() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub updateStamps";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="If CoffeeCount = 6 Then";
if (_coffeecount==6) { 
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="ToastMessageShow(\" You Have Earned A free Coffee\"";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(" You Have Earned A free Coffee",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="Activity.LoadLayout(\"freecoffee\") 'will load 2 la";
mostCurrent._activity.LoadLayout("freecoffee",mostCurrent.activityBA);
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="imgStamp1.Visible = True";
mostCurrent._imgstamp1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="imgStamp2.Visible = True";
mostCurrent._imgstamp2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="imgStamp3.Visible = True";
mostCurrent._imgstamp3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="imgStamp4.Visible = True";
mostCurrent._imgstamp4.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589832;
 //BA.debugLineNum = 589832;BA.debugLine="imgStamp5.Visible = True";
mostCurrent._imgstamp5.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589833;
 //BA.debugLineNum = 589833;BA.debugLine="imgStamp6.Visible = True";
mostCurrent._imgstamp6.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=589836;
 //BA.debugLineNum = 589836;BA.debugLine="If CoffeeCount = 5 Then 'from 5 to 1 will show ho";
if (_coffeecount==5) { 
RDebugUtils.currentLine=589837;
 //BA.debugLineNum = 589837;BA.debugLine="ToastMessageShow (\" You still need 1 more stamp i";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(" You still need 1 more stamp in order to get a free coffee",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589838;
 //BA.debugLineNum = 589838;BA.debugLine="imgStamp1.Visible = True";
mostCurrent._imgstamp1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589839;
 //BA.debugLineNum = 589839;BA.debugLine="imgStamp2.Visible = True";
mostCurrent._imgstamp2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589840;
 //BA.debugLineNum = 589840;BA.debugLine="imgStamp3.Visible = True";
mostCurrent._imgstamp3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589841;
 //BA.debugLineNum = 589841;BA.debugLine="imgStamp4.Visible = True";
mostCurrent._imgstamp4.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589842;
 //BA.debugLineNum = 589842;BA.debugLine="imgStamp5.Visible = True";
mostCurrent._imgstamp5.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589843;
 //BA.debugLineNum = 589843;BA.debugLine="imgStamp6.Visible = False";
mostCurrent._imgstamp6.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=589846;
 //BA.debugLineNum = 589846;BA.debugLine="If CoffeeCount = 4 Then";
if (_coffeecount==4) { 
RDebugUtils.currentLine=589847;
 //BA.debugLineNum = 589847;BA.debugLine="ToastMessageShow (\" You still need 2 more stamp i";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(" You still need 2 more stamp in order to get a free coffee",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589848;
 //BA.debugLineNum = 589848;BA.debugLine="imgStamp1.Visible = True";
mostCurrent._imgstamp1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589849;
 //BA.debugLineNum = 589849;BA.debugLine="imgStamp2.Visible = True";
mostCurrent._imgstamp2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589850;
 //BA.debugLineNum = 589850;BA.debugLine="imgStamp3.Visible = True";
mostCurrent._imgstamp3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589851;
 //BA.debugLineNum = 589851;BA.debugLine="imgStamp4.Visible = True";
mostCurrent._imgstamp4.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589852;
 //BA.debugLineNum = 589852;BA.debugLine="imgStamp5.Visible = False";
mostCurrent._imgstamp5.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589853;
 //BA.debugLineNum = 589853;BA.debugLine="imgStamp6.Visible = False";
mostCurrent._imgstamp6.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=589855;
 //BA.debugLineNum = 589855;BA.debugLine="If CoffeeCount = 3 Then";
if (_coffeecount==3) { 
RDebugUtils.currentLine=589856;
 //BA.debugLineNum = 589856;BA.debugLine="ToastMessageShow (\" You still need 3 more stamp i";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(" You still need 3 more stamp in order to get a free coffee",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589857;
 //BA.debugLineNum = 589857;BA.debugLine="imgStamp1.Visible = True";
mostCurrent._imgstamp1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589858;
 //BA.debugLineNum = 589858;BA.debugLine="imgStamp2.Visible = True";
mostCurrent._imgstamp2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589859;
 //BA.debugLineNum = 589859;BA.debugLine="imgStamp3.Visible = True";
mostCurrent._imgstamp3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589860;
 //BA.debugLineNum = 589860;BA.debugLine="imgStamp4.Visible = False";
mostCurrent._imgstamp4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589861;
 //BA.debugLineNum = 589861;BA.debugLine="imgStamp5.Visible = False";
mostCurrent._imgstamp5.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589862;
 //BA.debugLineNum = 589862;BA.debugLine="imgStamp6.Visible = False";
mostCurrent._imgstamp6.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=589864;
 //BA.debugLineNum = 589864;BA.debugLine="If CoffeeCount = 2 Then";
if (_coffeecount==2) { 
RDebugUtils.currentLine=589865;
 //BA.debugLineNum = 589865;BA.debugLine="ToastMessageShow (\" you still need 4  more stamp";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(" you still need 4  more stamp in order to get a free coffee",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589866;
 //BA.debugLineNum = 589866;BA.debugLine="imgStamp1.Visible = True";
mostCurrent._imgstamp1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589867;
 //BA.debugLineNum = 589867;BA.debugLine="imgStamp2.Visible = True";
mostCurrent._imgstamp2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589868;
 //BA.debugLineNum = 589868;BA.debugLine="imgStamp3.Visible = False";
mostCurrent._imgstamp3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589869;
 //BA.debugLineNum = 589869;BA.debugLine="imgStamp4.Visible = False";
mostCurrent._imgstamp4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589870;
 //BA.debugLineNum = 589870;BA.debugLine="imgStamp5.Visible = False";
mostCurrent._imgstamp5.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589871;
 //BA.debugLineNum = 589871;BA.debugLine="imgStamp6.Visible = False";
mostCurrent._imgstamp6.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=589873;
 //BA.debugLineNum = 589873;BA.debugLine="If CoffeeCount = 1 Then";
if (_coffeecount==1) { 
RDebugUtils.currentLine=589874;
 //BA.debugLineNum = 589874;BA.debugLine="ToastMessageShow (\" You still need 5  more stamp";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(" You still need 5  more stamp in order to get a free coffee",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589875;
 //BA.debugLineNum = 589875;BA.debugLine="imgStamp1.Visible = True";
mostCurrent._imgstamp1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=589876;
 //BA.debugLineNum = 589876;BA.debugLine="imgStamp2.Visible = False";
mostCurrent._imgstamp2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589877;
 //BA.debugLineNum = 589877;BA.debugLine="imgStamp3.Visible = False";
mostCurrent._imgstamp3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589878;
 //BA.debugLineNum = 589878;BA.debugLine="imgStamp4.Visible = False";
mostCurrent._imgstamp4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589879;
 //BA.debugLineNum = 589879;BA.debugLine="imgStamp5.Visible = False";
mostCurrent._imgstamp5.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589880;
 //BA.debugLineNum = 589880;BA.debugLine="imgStamp6.Visible = False";
mostCurrent._imgstamp6.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=589883;
 //BA.debugLineNum = 589883;BA.debugLine="If CoffeeCount = 0 Then";
if (_coffeecount==0) { 
RDebugUtils.currentLine=589884;
 //BA.debugLineNum = 589884;BA.debugLine="ToastMessageShow (\" Don't Forget to use your Coff";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(" Don't Forget to use your Coffe-E-Card when you buying  a coffee",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589885;
 //BA.debugLineNum = 589885;BA.debugLine="imgStamp1.Visible = False";
mostCurrent._imgstamp1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589886;
 //BA.debugLineNum = 589886;BA.debugLine="imgStamp2.Visible = False";
mostCurrent._imgstamp2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589887;
 //BA.debugLineNum = 589887;BA.debugLine="imgStamp3.Visible = False";
mostCurrent._imgstamp3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589888;
 //BA.debugLineNum = 589888;BA.debugLine="imgStamp4.Visible = False";
mostCurrent._imgstamp4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589889;
 //BA.debugLineNum = 589889;BA.debugLine="imgStamp5.Visible = False";
mostCurrent._imgstamp5.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589890;
 //BA.debugLineNum = 589890;BA.debugLine="imgStamp6.Visible = False";
mostCurrent._imgstamp6.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=589892;
 //BA.debugLineNum = 589892;BA.debugLine="End Sub";
return "";
}
public static String  _btnscan_longclick() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub btnScan_LongClick ' in order to scan the barco";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="qrscanner.isportrait = True";
mostCurrent._qrscanner.isportrait = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="qrscanner.useFrontCam = False";
mostCurrent._qrscanner.useFrontCam = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="qrscanner.timeoutDuration = 30";
mostCurrent._qrscanner.timeoutDuration = (int) (30);
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="qrscanner.theViewFinderXfactor = 0.7";
mostCurrent._qrscanner.theViewFinderXfactor = 0.7;
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="qrscanner.theViewFinderYfactor = 0.5";
mostCurrent._qrscanner.theViewFinderYfactor = 0.5;
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="qrscanner.theFrameColor = Colors.LightGray";
mostCurrent._qrscanner.theFrameColor = anywheresoftware.b4a.keywords.Common.Colors.LightGray;
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="qrscanner.theLaserColor = Colors.Red";
mostCurrent._qrscanner.theLaserColor = anywheresoftware.b4a.keywords.Common.Colors.Red;
RDebugUtils.currentLine=851982;
 //BA.debugLineNum = 851982;BA.debugLine="qrscanner.theMaskColor = Colors.argb(95, 0, 0, 25";
mostCurrent._qrscanner.theMaskColor = anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (95),(int) (0),(int) (0),(int) (255));
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="qrscanner.theResultColor = Colors.Green";
mostCurrent._qrscanner.theResultColor = anywheresoftware.b4a.keywords.Common.Colors.Green;
RDebugUtils.currentLine=851984;
 //BA.debugLineNum = 851984;BA.debugLine="qrscanner.theResultPointColor = Colors.Red";
mostCurrent._qrscanner.theResultPointColor = anywheresoftware.b4a.keywords.Common.Colors.Red;
RDebugUtils.currentLine=851986;
 //BA.debugLineNum = 851986;BA.debugLine="qrscanner.theBottomPromptMessage = \"Scan Your Cof";
mostCurrent._qrscanner.theBottomPromptMessage = "Scan Your Coffee Stamp.";
RDebugUtils.currentLine=851987;
 //BA.debugLineNum = 851987;BA.debugLine="qrscanner.theBottomPromptTextSize = 5%y";
mostCurrent._qrscanner.theBottomPromptTextSize = anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA);
RDebugUtils.currentLine=851988;
 //BA.debugLineNum = 851988;BA.debugLine="qrscanner.bottomPromptColor = Colors.Black";
mostCurrent._qrscanner.bottomPromptColor = anywheresoftware.b4a.keywords.Common.Colors.Black;
RDebugUtils.currentLine=851989;
 //BA.debugLineNum = 851989;BA.debugLine="qrscanner.bottomPromptDistanceFromBottom = 5%y";
mostCurrent._qrscanner.bottomPromptDistanceFromBottom = anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (5),mostCurrent.activityBA);
RDebugUtils.currentLine=851991;
 //BA.debugLineNum = 851991;BA.debugLine="qrscanner.BeginScan(\"scanner\")";
mostCurrent._qrscanner.BeginScan(mostCurrent.activityBA,"scanner");
RDebugUtils.currentLine=851992;
 //BA.debugLineNum = 851992;BA.debugLine="End Sub";
return "";
}
public static String  _myabbarcode_barcodefound(String _barcode,String _formatname) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub myABBarcode_BarcodeFound (barCode As String, f";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="Label1.Text = barCode";
mostCurrent._label1.setText((Object)(_barcode));
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="mResult = barCode";
_mresult = _barcode;
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="End Sub";
return "";
}
public static String  _no_click() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub No_Click ' you can also save and redeem later";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="activity.LoadLayout(\"main\") 'will return to main";
mostCurrent._activity.LoadLayout("main",mostCurrent.activityBA);
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="End Sub";
return "";
}
public static String  _scanner_noscan(String _atype,String _values) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub scanner_noscan(atype As String,Values As Strin";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="scanSuccess = False";
_scansuccess = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Log(\"type:\" & atype &  \"Values:\" & Values)";
anywheresoftware.b4a.keywords.Common.Log("type:"+_atype+"Values:"+_values);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="Msgbox(Values,\"Scan Failed\")";
anywheresoftware.b4a.keywords.Common.Msgbox(_values,"Scan Failed",mostCurrent.activityBA);
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="End Sub";
return "";
}
public static String  _scanner_result(String _atype,String _values) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub scanner_result(atype As String,Values As Strin";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="scanSuccess = True";
_scansuccess = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="CoffeeCount = CoffeeCount + 1";
_coffeecount = (int) (_coffeecount+1);
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="Log(\"type:\" & atype &  \"Values:\" & Values)";
anywheresoftware.b4a.keywords.Common.Log("type:"+_atype+"Values:"+_values);
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="updateStamps";
_updatestamps();
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="End Sub";
return "";
}
public static String  _yes_click() throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub yes_Click 'to redeem your free coffee press Ye";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Activity.LoadLayout(\"ABBarcodeTest\")";
mostCurrent._activity.LoadLayout("ABBarcodeTest",mostCurrent.activityBA);
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Label1.Text = mResult";
mostCurrent._label1.setText((Object)(_mresult));
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="myABBarcode.ABGetBarcode(\"myabbarcode\", \"\")";
mostCurrent._myabbarcode.ABGetBarcode(mostCurrent.activityBA,"myabbarcode","");
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="End Sub";
return "";
}
}