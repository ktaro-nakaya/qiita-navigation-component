package jp.co.casareal.navigationcomponent_sample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment

class StartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // NavHostの取得
        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment

        // NavController取得
        val navController = navHostFragment.navController

        // 確認画面に遷移
        view.findViewById<Button>(R.id.btn_confirm).setOnClickListener {
            val strName = view.findViewById<EditText>(R.id.edit_name).text.toString()
            val action =
                StartFragmentDirections.actionStartFragmentToFirstFragment(nameForConfirm = strName)
            navController.navigate(action)
        }

        // カウント画面に遷移
        view.findViewById<Button>(R.id.btn_count).setOnClickListener {
            val strName = view.findViewById<EditText>(R.id.edit_name).text.toString()
            val action =
                StartFragmentDirections.actionStartFragmentToSecondFragment(nameForCount = strName)

            navController.navigate(action)
        }
    }
}