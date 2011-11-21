package edu.semaster.checkers.menuview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class MenuClass 
{
  Display display;
  Shell shell;
  Menu menu, fileMenu, editMenu, viewMenu;

  /**
   * @wbp.parser.entryPoint
   */
  public MenuClass() 
  {
  display = new Display();
  shell = new Shell(display);
  shell.setText("Checkers Menu");
  shell.setSize(386, 200);

  menu = new Menu(shell, SWT.BAR);
  MenuItem gameItem = new MenuItem(menu, SWT.CASCADE);
  gameItem.setText("Game");
  MenuItem actionItem = new MenuItem(menu, SWT.CASCADE);
  actionItem.setText("Action");
  MenuItem rulesItem = new MenuItem(menu, SWT.CASCADE);
  rulesItem.setText("Rules");
  MenuItem historyItem = new MenuItem(menu, SWT.CASCADE);
  historyItem.setText("History");
  MenuItem aboutItem = new MenuItem(menu, SWT.CASCADE);
  aboutItem.setText("About Checkers");
  MenuItem helpItem = new MenuItem(menu, SWT.CASCADE);
  helpItem.setText("Help");
  


  Menu gameMenu = new Menu(menu);
  gameItem.setMenu(gameMenu);
  MenuItem newItem = new MenuItem(gameMenu, SWT.NONE);
  newItem.setText("New Game");
  MenuItem openItem = new MenuItem(gameMenu, SWT.NONE);
  openItem.setText("Open...");
  MenuItem saveItem = new MenuItem(gameMenu, SWT.NONE);
  saveItem.setText("Save");
  new MenuItem(gameMenu, SWT.SEPARATOR);
  MenuItem exitItem = new MenuItem(gameMenu, SWT.NONE);
  exitItem.setText("Exit");
  
  Menu openMenu = new Menu(menu);
  actionItem.setMenu(openMenu);
  MenuItem fileItem = new MenuItem(openMenu, SWT.NONE);
  fileItem.setText("Undo");
  
  Menu historyMenu = new Menu(menu);
  historyItem.setMenu(historyMenu);
  MenuItem previousGameItem = new MenuItem(historyMenu, SWT.NONE);
  previousGameItem.setText("Previous Game");
  
  Menu rulesMenu = new Menu(menu);
  rulesItem.setMenu(rulesMenu);
  MenuItem GamerulesItem = new MenuItem(rulesMenu, SWT.NONE);
  GamerulesItem.setText("Game Rules");
  
  Menu helpMenu = new Menu(menu);
  helpItem.setMenu(helpMenu);
  MenuItem helpContentsItem = new MenuItem(helpMenu, SWT.NONE);
  helpContentsItem.setText("Help Contents");
  
  
  
  
 // exitItem.addSelectionListener(new MenuItemListener());
  exitItem.addListener(SWT.Selection, new Listener()
  {
		public void handleEvent(Event event)
		{
			MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION
					| SWT.YES | SWT.NO);
			messageBox.setMessage("Are you sure you want to exit checkers?");
			messageBox.setText("Checkers");
			int rc = messageBox.open();

			System.out.println(rc == SWT.YES);
			System.out.println(rc == SWT.NO);
			
			
		}
  });
  
  
	newItem.addListener(SWT.Selection, new Listener()
	{
		public void handleEvent(Event event)
		{
			MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION
					| SWT.YES | SWT.NO);
			messageBox.setMessage("Create a new game?");
			messageBox.setText("Checkers");
			int rc = messageBox.open();

			System.out.println(rc == SWT.YES);
			System.out.println(rc == SWT.NO);
			
			
		}
		});
  
  shell.setMenuBar(menu);
  
  CoolBar coolBar = new CoolBar(shell, SWT.FLAT);
  coolBar.setBounds(-67, -30, 150, 30);
  shell.open();
  while (!shell.isDisposed()) 
  {
  if (!display.readAndDispatch())
  display.sleep();
  }
 }
  class MenuItemListener extends SelectionAdapter 
  {
  public void widgetSelected(SelectionEvent event) 
  {
  if (((MenuItem) event.widget).getText().equals("Exit"))
  {
  shell.close();
  }
 }
  }
  public static void main(String[] args) 
  {
  MenuClass example = new MenuClass();
	  //example.open();
  }
}