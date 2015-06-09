Type=Class
Version=5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module

Sub Class_Globals
	
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize

End Sub


Sub SaveCard(CoffeeCount As Int, BonusNumber As Int)
CoffeeCount = 1
BonusNumber = 7
Dim CountFromCard As Int

''If the file doesn't exist, then create it
If File.Exists(File.DirInternal, "CoffeeCount.txt") = False Then
File.WriteString(File.DirInternal, "CoffeeCount.txt", CoffeeCount)

''load the file, which will just hold the number of coffees
Else
CountFromCard =    File.ReadString(File.DirInternal, "CoffeeCount.txt")

'add the Coffee count to it
CountFromCard = CountFromCard + CoffeeCount

'save the new number back to the file
File.WriteString(File.DirInternal, "CoffeeCount.txt", CountFromCard)

'if the number = bonus number then ....

End If


End Sub


Public Sub CreateCard(CardName As String, StampCount As Int, BonusNumber As Int)
    If(File.Exists(File.DirInternal, CardName) = False) Then
	File.WriteString(File.DirInternal, CardName, StampCount & "," & BonusNumber)
	End If
End Sub


Public Sub LoadCard(CardName As String) As Int()
	Dim BonusNumber As Int = 7 'defaults
	Dim StampCount As Int = 0
	Dim cardData As String
	
	If File.Exists(File.DirInternal, CardName) = False Then
	File.WriteString(File.DirInternal, CardName, "0,7") 'default values??
	End If
	
	If(File.Exists(File.DirInternal, CardName)) Then
	cardData = File.ReadString(File.DirInternal, CardName)
	Dim SplitIndex As Int = cardData.IndexOf(",")
	
	ToastMessageShow(cardData, True)
	StampCount = cardData.SubString2(0,SplitIndex)
	BonusNumber = cardData.SubString(SplitIndex+1)
	End If
	
	Dim IntData(2) As Int
	IntData(0) = StampCount
	IntData(1) = BonusNumber
	Return IntData
	End Sub
