package codemaster.servlet.log4jFile;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import codemaster.servlet.entity.Account;
import codemaster.servlet.model.AtmModel;

public class Log4jFile {

	private static final String INFOR = "infor";
	private static final String ERROR = "error";
	private static final Logger fileInforLog = Logger.getLogger(INFOR);
	private static final Logger fileErrorLog = Logger.getLogger(ERROR);

	public static void writeError(String message, Throwable t) {
		fileErrorLog.info(message, t);
	}

	public static void writeError1(Account message, Throwable t) {
		fileErrorLog.info(message, t);
	}

	public static void writeError2(ArrayList<Account> message, Throwable t) {
		fileErrorLog.info(message, t);
	}

	// ---------------------------------

	public static void writeInfor(String message) {
		fileInforLog.info(message);
	}

	public static void writeInfor1(Account message) {
		fileInforLog.info(message);
	}

	public static void writeInfor2(ArrayList<Account> message) {
		fileInforLog.info(message);
	}

	public static void writeInfor3(AtmModel message) {
		fileInforLog.info(message);
	}

}
