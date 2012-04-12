package com.pruebas.slocker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SumaNumActivity extends Activity {

	private TextView textViewResult, textViewInfo, textViewErrorResult;
	private EditText editTextOp1, editTextOp2;
	private Button botonBorrar, botonOperacion;
	private LinearLayout layoutContenido;

	protected String stringOp1, stringOp2;
	float op1, op2, resultado;
	protected boolean op1Empty, op2Empty;
	private RadioGroup radioGrupoOperacion;
	protected int tipoOperacion;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculadora);

		textViewResult = (TextView) findViewById(R.id.resultado);
		textViewErrorResult = (TextView) findViewById(R.id.ErrorResultado);
		textViewInfo = (TextView) findViewById(R.id.textViewInfo);

		editTextOp1 = (EditText) findViewById(R.id.operando1);
		editTextOp2 = (EditText) findViewById(R.id.operando2);

		layoutContenido = (LinearLayout) findViewById(R.id.LayoutContenido);
//		layoutContenido.setBackgroundColor(Color.parseColor("#55ffffff"));


		botonBorrar = (Button) findViewById(R.id.botonBorra);
		botonBorrar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				borrarOperandos();

			}
		});

		radioGrupoOperacion = (RadioGroup) findViewById(R.id.radioGrupoOperacion);

		botonOperacion = (Button) findViewById(R.id.botonOperacion);
		botonOperacion.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(editTextOp1.getWindowToken(), 0);

				op1Empty = false;
				op2Empty = false;
				textViewErrorResult.setText("");

				tipoOperacion = radioGrupoOperacion.getCheckedRadioButtonId();
				switch (tipoOperacion) {
				case (R.id.radio0):
					textViewInfo.setText("ESTAS SUMANDO");

					obtenerOp1();
					obtenerOp2();
					resultado = suma(op1, op2);
					mostrarResultado();
					break;

				case (R.id.radio1):
					textViewInfo.setText("ESTAS RESTANDO");

					obtenerOp1();
					obtenerOp2();

					resultado = resta(op1, op2);
					mostrarResultado();
					break;
				case (R.id.radio2):
					textViewInfo.setText("ESTAS MULTIPLICANDO");

					obtenerOp1();
					obtenerOp2();

					resultado = multiplica(op1, op2);
					mostrarResultado();
					break;
				case (R.id.radio3):
					textViewInfo.setText("ESTAS DIVIDIENDO");

					obtenerOp1();
					obtenerOp2();
					resultado = divide(op1, op2);
					mostrarResultado();
					break;
				default:
					textViewInfo.setText("error con lso radiobuttons");
					break;
				}

			}
		});
	}

	protected void obtenerOp1() {
		stringOp1 = editTextOp1.getText().toString();
		try {
			op1 = Float.parseFloat(stringOp1);

		} catch (Exception e) {
			op1Empty = true;
			textViewErrorResult.append("Operando 1 invalido\n");
		}
	}

	protected void obtenerOp2() {
		stringOp2 = editTextOp2.getText().toString();
		try {
			op2 = Float.parseFloat(stringOp2);
		} catch (Exception e) {
			op2Empty = true;
			textViewErrorResult.append("Operando 2 invalido\n");
		}

	}

	protected void mostrarResultado() {
		if (!op1Empty && !op2Empty) {
			textViewResult.setText("" + resultado);
		}

	}

	protected void borrarOperandos() {
		editTextOp1.setText("");
		editTextOp2.setText("");
		textViewResult.setText("");
		textViewErrorResult.setText("");
		textViewInfo.setText("");

	}

	protected float suma(float op1, float op2) {
		return op1 + op2;
	}

	protected float resta(float op1, float op2) {
		return op1 - op2;
	}

	protected float multiplica(float op1, float op2) {
		return op1 * op2;
	}

	protected float divide(float op1, float op2) {
		return op1 / op2;
	}
}