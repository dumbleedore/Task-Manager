import type { AppProps } from "next/app";
import { Box, ChakraProvider } from "@chakra-ui/react";
import { mynewTheme } from "../styles/theme";

export default function App({ Component, pageProps }: AppProps) {
  return (
    <ChakraProvider theme={mynewTheme}>
      <Box bg="primary" h="calc(100vh)">
        <Component {...pageProps} />
      </Box>
    </ChakraProvider>
  );
}
