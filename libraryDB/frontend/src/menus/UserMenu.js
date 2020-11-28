import React from 'react'
import {Grid, TextField, Button} from '@material-ui/core'

import { useHistory } from "react-router-dom";

export default function ShowMenu() {

    const history = useHistory();
    const showBooks = () => history.push('/books');
    const showWishList = () => history.push('/wishlist#/wishlist');

    return(
        <Grid
            container
            direction="row"
            justify="center"
            alignItems="center"
            >
            <div>
                <form>
                    <Grid item xs={12}>
                        <h1>
                        Hello User
                        </h1>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="change_data_button" variant ="contained" color="primary">
                        Change personal data
                        </Button>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="change_data_button" variant ="contained" color="primary" onClick={showBooks}>
                        Show books
                        </Button>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="button_find_book" variant ="contained" color="primary">
                        Find book
                        </Button>
                    </Grid>
                    <Grid item xs={12}>
                        <Button id="button_log_out" variant ="contained" color="primary">
                        Log out
                        </Button>
                    </Grid>
                </form>
            </div>
        </Grid>
    );
}