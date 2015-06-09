Type=Class
Version=5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	Dim random As Int
	Dim ImageViews1 As ImageView
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub
public Sub redeem	
If redeem = 1 Then
ImageViews1.Bitmap = LoadBitmap(File.DirAssets, "1.jpg")
End If
If redeem = 2 Then 
ImageViews1.Bitmap = LoadBitmap(File.DirAssets, "2.jpg")
End If 
If redeem = 3 Then
ImageViews1.Bitmap = LoadBitmap(File.DirAssets, "3.png")
End If 
If redeem = 4 Then
ImageViews1.Bitmap = LoadBitmap(File.DirAssets, "4.png")
End If 
If redeem = 5 Then
ImageViews1.Bitmap = LoadBitmap(File.DirAssets, "5.png")
End If
If redeem = 6 Then 
ImageViews1.Bitmap = LoadBitmap(File.DirAssets, "6.png")
End If
If redeem = 7 Then 
ImageViews1.Bitmap = LoadBitmap(File.DirAssets, "7.png")
End If 
If redeem= 8 Then 
ImageViews1.Bitmap = LoadBitmap(File.DirAssets, "8.png")
End If 
random = redeem
random = Rnd(1, 9)

End Sub





