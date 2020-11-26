import React from 'react'
import {Grid, TextField, Button} from '@material-ui/core'

export default function ShowMenu() {
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