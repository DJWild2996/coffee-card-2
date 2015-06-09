Type=Class
Version=5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module

'create a default theme (stamps images, logo image, company name as label, button properties) send to coffee activity
'If website/url is available grab colours logo and button colours.
'theme manager
Sub Class_Globals
Private SQL1 As SQL
Private cursor1 As Cursor
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize
	
	'  Removed below line as after we made changes to our database they weren't initialised
	
	'If File.Exists(File.DirInternal, "customerthemes.sqlite")=False Then
	File.Copy(File.DirAssets, "customerthemes.sqlite",File.DirInternal,"customerthemes.sqlite")
	'End If
	
	'if not already initialised then action.
	If SQL1.IsInitialized=False Then
	SQL1.Initialize(File.DirInternal, "customerthemes.sqlite", False)
	End If
End Sub

Sub loadColours As Cursor
cursor1=SQL1.ExecQuery("SELECT BG1Red, BG1Blue, BG1Green, BG2Red, BG2Blue, BG2Green FROM themes")
'Log("BGColor1, BGColor2")
Return cursor1
End Sub
Sub loadLogo As Cursor
cursor1=SQL1.ExecQuery("SELECT Logo FROM themes")
Return cursor1
End Sub

Sub loadCompanyName As Cursor
cursor1=SQL1.ExecQuery("SELECT CompanyName FROM themes")
Return cursor1
End Sub

Sub loadStampIcon As Cursor
cursor1=SQL1.ExecQuery("SELECT StampIcon FROM themes")
Return cursor1
End Sub

'pulls in colour RBG from database
Sub loadBtnColours As Cursor
cursor1=SQL1.ExecQuery("SELECT BtnRed, BtnBlue, BtnGreen FROM themes")
Return cursor1
End Sub
