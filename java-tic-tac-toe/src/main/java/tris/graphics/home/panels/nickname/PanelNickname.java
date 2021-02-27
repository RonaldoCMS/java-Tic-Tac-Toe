package tris.graphics.home.panels.nickname;


import tris.util.LabelTris;
import tris.util.RowTris;
import tris.util.TextFieldTris;

public class PanelNickname extends RowTris {

	private TextFieldTris textField;
	private LabelTris label;
	
	public PanelNickname() {
		super("Nickname: ");
		setLayout(null);
		
		
		textField = new TextFieldTris();
		textField.getTextField().setBounds(0, 0, 170, 38);
		textField.setBounds(130, 0, 170, 60);
		add(textField);
		
		label = new LabelTris("Nickname: ");
		label.setBounds(0, 0, 131, 39);
		add(label);
	}

	public TextFieldTris getTextField() {
		return textField;
	}

	public void setTextField(TextFieldTris textField) {
		this.textField = textField;
	}
}
