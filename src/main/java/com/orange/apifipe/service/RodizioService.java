package com.orange.apifipe.service;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class RodizioService {

	public static String rodizioDia(Integer ano) {
		int dia = rodizioRegra(ano);
		DateFormatSymbols simbolo = new DateFormatSymbols(new Locale("pt", "BR"));
		String[] diaSemana = simbolo.getWeekdays();
		return diaSemana[dia];
	}

	public static Boolean emRodizio(Integer ano) {
		Calendar hoje = Calendar.getInstance(new Locale("pt", "BR"));
		return hoje.get(Calendar.DAY_OF_WEEK) == rodizioRegra(ano);
	}

	private static int rodizioRegra(Integer ano) {
		String finalAno = ano.toString().substring(3);

		if (finalAno.equals("0") || finalAno.equals("1")) {
			return Calendar.MONDAY;
		}
		if (finalAno.equals("2") || finalAno.equals("3")) {
			return Calendar.TUESDAY;
		}
		if (finalAno.equals("4") || finalAno.equals("5")) {
			return Calendar.WEDNESDAY;
		}
		if (finalAno.equals("6") || finalAno.equals("7")) {
			return Calendar.THURSDAY;
		}
		if (finalAno.equals("8") || finalAno.equals("9")) {
			return Calendar.FRIDAY;
		}

		return 0;
	}
}
