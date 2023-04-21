package com.bitcodetech.recyclerview3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bitcodetech.recyclerview3.adapters.CallsAdapter
import com.bitcodetech.recyclerview3.models.Advertisement
import com.bitcodetech.recyclerview3.models.CallInfo

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerCalls: RecyclerView

    private val callsInfo = ArrayList<CallInfo>()
    private val advertisements = ArrayList<Advertisement>()
    private lateinit var callsAdapter: CallsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        initViews()
        setupListeners()
    }

    private fun setupListeners() {
        callsAdapter.onAdvertisementClickListener =
            object : CallsAdapter.OnAdvertisementClickListener {
                override fun onAdvertisementClick(advertisement: Advertisement, advPosition: Int) {
                    mt("Adv: ${advertisement.title}")
                }
            }

        callsAdapter.onCallInfoClickListener =
            object : CallsAdapter.OnCallInfoClickListener {
                override fun onContactImageClick(callInfo: CallInfo, callPosition: Int) {
                    mt("Call Info Image: ${callInfo.name}")
                }

                override fun onContactNameClick(callInfo: CallInfo, callPosition: Int) {
                    mt("Call Info Name: ${callInfo.name}")
                }

                override fun onContactNumberClick(callInfo: CallInfo, callPosition: Int) {
                    mt("Call Info Number: ${callInfo.name}")
                }

            }
    }

    private fun initData() {

        callsInfo.add(
            CallInfo(
                null,
                "9881125904",
                R.mipmap.ic_launcher,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode1",
                "9881125901",
                R.mipmap.ic_launcher,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode2",
                "9881125902",
                R.mipmap.ic_launcher,
                System.currentTimeMillis(),
                CallInfo.TYPE_OUTGOING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode3",
                "9881125903",
                null,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode",
                "9881125904",
                R.mipmap.ic_launcher,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode1",
                "9881125905",
                R.mipmap.ic_launcher,
                System.currentTimeMillis(),
                CallInfo.TYPE_OUTGOING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode",
                "9881125906",
                R.mipmap.ic_launcher,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode4",
                "9881125904",
                R.mipmap.ic_launcher,
                System.currentTimeMillis(),
                CallInfo.TYPE_OUTGOING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode5",
                "9881125904",
                R.mipmap.ic_launcher,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode",
                "9881126677",
                null,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode7",
                "9881125900",
                R.mipmap.ic_launcher,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode8",
                "9881112345",
                R.mipmap.ic_launcher,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )
        callsInfo.add(
            CallInfo(
                "BitCode",
                "9881125904",
                R.mipmap.ic_launcher,
                System.currentTimeMillis(),
                CallInfo.TYPE_INCOMING.toByte()
            )
        )

        advertisements.add(
            Advertisement(
                "Get Job in 30 days!",
                R.mipmap.ic_launcher,
                "https://bitcode.in"
            )
        )
        advertisements.add(
            Advertisement(
                "Get Job without Study!",
                R.mipmap.ic_launcher,
                "https://bitcode.in"
            )
        )
        advertisements.add(
            Advertisement(
                "Get Job at Google!",
                R.mipmap.ic_launcher,
                "https://bitcode.in"
            )
        )
        advertisements.add(
            Advertisement(
                "Facebook is waiting for you!",
                R.mipmap.ic_launcher,
                "https://bitcode.in"
            )
        )
        advertisements.add(
            Advertisement(
                "Leave BitCode and get job!",
                R.mipmap.ic_launcher,
                "https://bitcode.in"
            )
        )
    }

    private fun initViews() {
        recyclerCalls = findViewById(R.id.recyclerCalls)
        recyclerCalls.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        callsAdapter = CallsAdapter(callsInfo, advertisements)
        recyclerCalls.adapter = callsAdapter
    }

    private fun mt(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}


