package com.vrlc92.liskmonitor.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by victorlins on 4/16/16.
 */

public class Account {
    private String address;
    private String publicKey;
    private String username;
    private Long unconfirmedBalance;
    private Long balance;

    private static String TAG = Account.class.getSimpleName();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUnconfirmedBalance() {
        return unconfirmedBalance;
    }

    public void setUnconfirmedBalance(Long unconfirmedBalance) {
        this.unconfirmedBalance = unconfirmedBalance;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public static Account fromJson(JSONObject jsonObject) {
        Account account = new Account();

        if (jsonObject == null) {
            return account;
        }

        try {
            account.address = jsonObject.getString("address");
        } catch (JSONException e) {
            Logger.getLogger(TAG).warning(String.format("account.address (%s)", e.getLocalizedMessage()));
        }

        try {
            account.publicKey = jsonObject.getString("publicKey");
        } catch (JSONException e) {
            Logger.getLogger(TAG).warning(String.format("account.publicKey (%s)", e.getLocalizedMessage()));
        }

        try {
            account.username = jsonObject.getString("username");
        } catch (JSONException e) {
            Logger.getLogger(TAG).warning(String.format("account.username (%s)", e.getLocalizedMessage()));
        }

        try {
            account.unconfirmedBalance = jsonObject.getLong("unconfirmedBalance");
        } catch (JSONException e) {
            Logger.getLogger(TAG).warning(String.format("account.unconfirmedBalance (%s)", e.getLocalizedMessage()));
        }

        try {
            account.balance = jsonObject.getLong("balance");
        } catch (JSONException e) {
            Logger.getLogger(TAG).warning(String.format("account.balance (%s)", e.getLocalizedMessage()));
        }

        return account;
    }

    public static List<Account> fromJson(JSONArray accountsJsonArray) {
        List<Account> accounts = new ArrayList<Account>();

        if (accountsJsonArray != null) {
            for (int i = 0; i < accountsJsonArray.length(); i++) {
                JSONObject accountJsonObject = null;
                try {
                    accountJsonObject = accountsJsonArray.getJSONObject(i);
                } catch (JSONException e) {
                    Logger.getLogger(TAG).warning(e.getLocalizedMessage());
                }

                if (accountJsonObject != null) {
                    accounts.add(Account.fromJson(accountJsonObject));
                }
            }
        }

        return accounts;
    }
}