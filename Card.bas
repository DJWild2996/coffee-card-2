Type=Class
Version=5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
Dim Card As Card
Dim Coffeecount As Int
Dim img7 As Bitmap 	
End Sub

Public Sub Initialize
'Initializes the object. You can add parameters to this method if needed.
End Sub

Sub CoffeeStamp As Int
Coffeecount = Coffeecount + 1 'Adds 1 stamp to coffee count when a coffee is scanned
Return Coffeecount ' and returns the new number of stamps the users has towards a free coffee
End Sub 
Sub Redeem As Boolean  'this part of code will hold the free coffe that the customer will get after getting 6 stamps 
If Coffeecount = 6 Then ' if the person got 6 stamps he earns 1 free coffee
img7.Initialize(File.DirAssets,"free-coffee-1-2.jpg")
'Msgbox ("You have earned a free coffee") 'msgbox option notifying  about the free coffee
Return True
End If
Return False
End Sub
