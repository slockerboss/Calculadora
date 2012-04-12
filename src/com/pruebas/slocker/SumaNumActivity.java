package com.pruebas.slocker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SumaNumActivity extends Activity {

	private TextView textView1, textView2, textViewResult, textViewInfo;
	private EditText editTextOp1, editTextOp2;
	private Button botonSuma, botonBorrar, botonOperacion;
	private RadioButton radioButton1;

	protected String stringOp1, stringOp2;
	float op1, op2, resultado;
	protected boolean op1Empty, op2Empty;
	private RadioGroup radioGrupoOperacion;
	protected int tipoOperacion;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculadora);

		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textViewResult = (TextView) findViewById(R.id.resultado);
		textViewInfo = (TextView) findViewById(R.id.textViewInfo);

		editTextOp1 = (EditText) findViewById(R.id.operando1);
		editTextOp2 = (EditText) findViewById(R.id.operando2);

		botonSuma = (Button) findViewById(R.id.botonSuma);
		botonSuma.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				op1Empty = false;
				op2Empty = false;

				textViewResult.setText("");

				stringOp1 = editTextOp1.getText().toString();
				try {
					op1 = Float.parseFloat(stringOp1);

				} catch (Exception e) {
					op1Empty = true;
					textViewResult.append("Operando 1 invalido\n");
				}

				stringOp2 = editTextOp2.getText().toString();
				try {
					op2 = Float.parseFloat(stringOp2);
				} catch (Exception e) {
					op2Empty = true;
					textViewResult.append("Operando 2 invalido\n");
				}

				resultado = suma(op1, op2);
				if (!op1Empty && !op2Empty) {
					textViewResult.setText("El resultado es: " + resultado);
				}

			}
		});

		botonBorrar = (Button) findViewById(R.id.botonBorra);
		botonBorrar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				borrarOperandos();

			}
		});

		radioButton1 = (RadioButton) findViewById(R.id.radio0);
		radioGrupoOperacion = (RadioGroup) findViewById(R.id.radioGrupoOperacion);

		botonOperacion = (Button) findViewById(R.id.botonOperacion);
		botonOperacion.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				tipoOperacion = radioGrupoOperacion.getCheckedRadioButtonId();
				switch (tipoOperacion) {
				case (R.id.radio0):
					textViewInfo.setText("ESTAS SUMANDO");
					op1Empty = false;
					op2Empty = false;

					textViewResult.setText("");

					stringOp1 = editTextOp1.getText().toString();
					try {
						op1 = Float.parseFloat(stringOp1);

					} catch (Exception e) {
						op1Empty = true;
						textViewResult.append("Operando 1 invalido\n");
					}

					stringOp2 = editTextOp2.getText().toString();
					try {
						op2 = Float.parseFloat(stringOp2);
					} catch (Exception e) {
						op2Empty = true;
						textViewResult.append("Operando 2 invalido\n");
					}

					resultado = suma(op1, op2);
					if (!op1Empty && !op2Empty) {
						textViewResult.setText("El resultado es: " + resultado);
					}
					break;
				case (R.id.radio1):
					textViewInfo.setText("ESTAS RESTANDO");
					op1Empty = false;
					op2Empty = false;

					textViewResult.setText("");

					stringOp1 = editTextOp1.getText().toString();
					try {
						op1 = Float.parseFloat(stringOp1);

					} catch (Exception e) {
						op1Empty = true;
						textViewResult.append("Operando 1 invalido\n");
					}

					stringOp2 = editTextOp2.getText().toString();
					try {
						op2 = Float.parseFloat(stringOp2);
					} catch (Exception e) {
						op2Empty = true;
						textViewResult.append("Operando 2 invalido\n");
					}

					resultado = resta(op1, op2);
					if (!op1Empty && !op2Empty) {
						textViewResult.setText("El resultado es: " + resultado);
					}
					break;
				case (R.id.radio2):
					textViewInfo.setText("radio 2");
					break;
				}

			}
		});
	}

	protected float suma(float op1, float op2) {
		return op1 + op2;
	}

	protected float resta(float op1, float op2) {
		return op1 - op2;
	}

	protected void borrarOperandos() {
		editTextOp1.setText("");
		editTextOp2.setText("");
		textViewResult.setText("");
		textViewInfo.setText("");

	}
}