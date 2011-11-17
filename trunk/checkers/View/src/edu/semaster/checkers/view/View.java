package edu.semaster.checkers.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class View
{

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			View window = new View();
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		Image image = new Image(display,
				View.class.getResourceAsStream("board.jpg"));
		
		Image redFigure = new Image(display,
				View.class.getResourceAsStream("red_normal.jpg"));
		GC gc = new GC(image);
		gc.drawImage(redFigure, 22, 20);
		gc.drawImage(redFigure, 138, 20);
		gc.drawImage(redFigure, 254, 20);
		gc.drawImage(redFigure, 370, 20);

		gc.drawImage(redFigure, 80, 80);
		gc.drawImage(redFigure, 196, 80);
		gc.drawImage(redFigure, 310, 80);
		gc.drawImage(redFigure, 427, 80);

		gc.drawImage(redFigure, 22, 140);
		gc.drawImage(redFigure, 138, 140);
		gc.drawImage(redFigure, 254, 140);
		gc.drawImage(redFigure, 370, 140);

		Button button = new Button(shell, SWT.PUSH);
		button.setImage(redFigure);
		
	
		
		Image yellowFigure = new Image(display,
				View.class.getResourceAsStream("yellow_normal.jpg"));
		gc.drawImage(yellowFigure, 80, 430);
		gc.drawImage(yellowFigure, 196, 430);
		gc.drawImage(yellowFigure, 312, 430);
		gc.drawImage(yellowFigure, 428, 430);

		gc.drawImage(yellowFigure, 22, 370);
		gc.drawImage(yellowFigure, 138, 370);
		gc.drawImage(yellowFigure, 254, 370);
		gc.drawImage(yellowFigure, 370, 370);

		gc.drawImage(yellowFigure, 80, 310);
		gc.drawImage(yellowFigure, 196, 310);
		gc.drawImage(yellowFigure, 312, 310);
		gc.drawImage(yellowFigure, 428, 310);

		shell.addMouseMoveListener(new MouseMoveListener() 
		{

			public void mouseMove(MouseEvent arg0) 
			{
				System.out.println(arg0.x + " , " + arg0.y);

			}
		});

		gc.dispose();

		shell.setBackgroundImage(image);
		shell.open();
		shell.layout();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch()) 
			{
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(498, 525);
		shell.setText("Checkers Game");

	}

}
