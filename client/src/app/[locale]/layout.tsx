import Navbar from '@components/navbar.component'
import { ThemeProvider } from '@components/theme-provider.component'
import type { Metadata } from 'next'
import { Inter } from 'next/font/google'
import './globals.css'
import { Providers } from './providers'

const inter = Inter({ subsets: ['latin'] })

export const metadata: Metadata = {
  title: 'Recherche floue',
  description: 'Recherche floue avec postgres et spring boot',
}

type RootLayoutProps = {
  children: React.ReactNode
  params: {
    locale: string
  }
}

export default function RootLayout(props: Readonly<RootLayoutProps>) {
  const { children, params } = props
  const { locale } = params

  return (
    <html lang={locale}>
      <body className={inter.className}>
        <Providers>
          <ThemeProvider
            attribute="class"
            defaultTheme="system"
            enableSystem
            disableTransitionOnChange
          >
            <Navbar />
            {children}
          </ThemeProvider>
        </Providers>
      </body>
    </html>
  )
}
