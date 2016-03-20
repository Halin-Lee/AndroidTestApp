package me.halin.testapp.SearchableActivity;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by halin on 12/14/15.
 */
public class SearchableProvider extends SearchRecentSuggestionsProvider {


    public SearchableProvider() {
        setupSuggestions("AUTHORITY", DATABASE_MODE_QUERIES);

    }
}
