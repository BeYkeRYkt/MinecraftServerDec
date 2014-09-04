package net.minecraft;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class ServerGUI extends JComponent {

	private static final Font font = new Font("Monospaced", 0, 12);
	private static final Logger logger = LogManager.getLogger();
	private DedicatedMinecraftServer minecraftserver;

	public static void oper(DedicatedMinecraftServer var0) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception var3) {
		}

		ServerGUI gui = new ServerGUI(var0);
		JFrame mainframe = new JFrame("Minecraft server");
		mainframe.add(gui);
		mainframe.pack();
		mainframe.setLocationRelativeTo((Component) null);
		mainframe.setVisible(true);
		mainframe.addWindowListener(new WindowCloseListener(var0));
	}

	public ServerGUI(DedicatedMinecraftServer var1) {
		this.minecraftserver = var1;
		this.setPreferredSize(new Dimension(854, 480));
		this.setLayout(new BorderLayout());

		try {
			this.add(this.c(), "Center");
			this.add(this.a(), "West");
		} catch (Exception var3) {
			logger.error("Couldn\'t build server GUI", (Throwable) var3);
		}

	}

	private JComponent a() {
		JPanel var1 = new JPanel(new BorderLayout());
		var1.add(new qd(this.minecraftserver), "North");
		var1.add(this.b(), "Center");
		var1.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
		return var1;
	}

	private JComponent b() {
		qc var1 = new qc(this.minecraftserver);
		JScrollPane var2 = new JScrollPane(var1, 22, 30);
		var2.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
		return var2;
	}

	private JComponent c() {
		JPanel var1 = new JPanel(new BorderLayout());
		JTextArea var2 = new JTextArea();
		JScrollPane var3 = new JScrollPane(var2, 22, 30);
		var2.setEditable(false);
		var2.setFont(font);
		JTextField var4 = new JTextField();
		var4.addActionListener(new py(this, var4));
		var2.addFocusListener(new pz(this));
		var1.add(var3, "Center");
		var1.add(var4, "South");
		var1.setBorder(new TitledBorder(new EtchedBorder(), "Log and chat"));
		Thread var5 = new Thread(new qa(this, var2, var3));
		var5.setDaemon(true);
		var5.start();
		return var1;
	}

	public void a(JTextArea var1, JScrollPane var2, String var3) {
		if (!SwingUtilities.isEventDispatchThread()) {
			SwingUtilities.invokeLater(new qb(this, var1, var2, var3));
		} else {
			Document var4 = var1.getDocument();
			JScrollBar var5 = var2.getVerticalScrollBar();
			boolean var6 = false;
			if (var2.getViewport().getView() == var1) {
				var6 = (double) var5.getValue() + var5.getSize().getHeight() + (double) (font.getSize() * 4) > (double) var5.getMaximum();
			}

			try {
				var4.insertString(var4.getLength(), var3, (AttributeSet) null);
			} catch (BadLocationException var8) {
				;
			}

			if (var6) {
				var5.setValue(Integer.MAX_VALUE);
			}

		}
	}

	// $FF: synthetic method
	static DedicatedMinecraftServer a(ServerGUI var0) {
		return var0.minecraftserver;
	}

}
