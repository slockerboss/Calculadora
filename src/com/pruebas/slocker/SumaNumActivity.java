package com.pruebas.slocker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SumaNumActivity extends Activity {

	TextView textView1, textView2, textViewResult;
	EditText editTextOp1, editTextOp2;
	Button botonSuma;

	protected String stringOp1, stringOp2;
	float op1, op2, resultado;
	protected boolean op1Empty, op2Empty;
	private Button botonBorrar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculadora);

		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textViewResult = (TextView) findViewById(R.id.resultado);

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

	}

	protected float suma(float op1, float op2) {
		return op1 + op2;
	}

	protected void borrarOperandos() {
		editTextOp1.setText("");
		editTextOp2.setText("");

	}
}